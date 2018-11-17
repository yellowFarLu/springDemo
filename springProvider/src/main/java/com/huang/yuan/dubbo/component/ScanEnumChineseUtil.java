package com.huang.yuan.dubbo.component;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.reflections.ReflectionUtils;
import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

/**
 * 基于包扫描所有枚举类，包括内部类，找出含有中文的字段生成 key-value
 */
public class ScanEnumChineseUtil {

    private static AtomicInteger enumItemsNum = new AtomicInteger(0);
    private static final String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    private static Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");

    private static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    private static MutablePropertySources propertySources = new MutablePropertySources();

    private static final ConfigurablePropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);

    private static MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);


    public static void main(String[] args) throws Exception {
        //基础包的位置，类似于spring <context:component-scan>配置中的内容，支持通配符
        String basePackages = "com.facishare.wechat.union.core.provider";

        List<String> basePackageList = Splitter.on(",").splitToList(basePackages);
        if(!CollectionUtils.isEmpty(basePackageList)) {
            for (String basePackage : basePackageList) {
                Resource[] resources = resolveBasePackage(basePackage);
                for(Resource resource : resources) {
                    handResource(resource);
                }
            }
        }

        System.out.println("total itemsNum = " + enumItemsNum.get());
    }

    private static void handResource(Resource resource) throws Exception {
        String className = metadataReaderFactory.getMetadataReader(resource).getAnnotationMetadata().getClassName();
        Class clazz = ClassUtils.forName(className, ScanEnumChineseUtil.class.getClassLoader());
        if(clazz.isEnum()) {
            System.out.println(className + "枚举下有这些中文项:");
            Method method = clazz.getMethod("values");
            Object[] enumItems =  (Object[])method.invoke(null);
            for (Object item : enumItems) {
                Set<Field> fields = ReflectionUtils.getAllFields(clazz);
                String enumName = getEnumName(item, clazz);
                fields.forEach(fieldItem -> {
                    try {
                        if(fieldItem.getType() == String.class) {
                            fieldItem.setAccessible(true);
                            String fieldName = fieldItem.getName();
                            //去除重复项目
                            if (!fieldName.equals(fieldItem.get(item).toString())) {
                                Matcher matcher = pattern.matcher(fieldItem.get(item).toString());
                                if (matcher.find()) {
                                    String keyVal = Joiner.on(".").join(className, enumName, fieldName + "=" + fieldItem.get(item)).toString();
                                    enumItemsNum.incrementAndGet();
                                    System.out.println(keyVal);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    private static Resource[] resolveBasePackage(String basePackage) throws Exception {
        String resolvePath = ClassUtils.convertClassNameToResourcePath(propertyResolver.resolveRequiredPlaceholders(basePackage));
        String packageSearchPath = CLASSPATH_ALL_URL_PREFIX + resolvePath + "/" + DEFAULT_RESOURCE_PATTERN;
        Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);

        return resources;
    }

    private static String getEnumName(Object item,  Class clazz) throws Exception {
        Set<Field> fields = ReflectionUtils.getAllFields(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            if("name".equals(field.getName())) {
                return field.get(item).toString();
            }
        }
        return "";
    }
}
