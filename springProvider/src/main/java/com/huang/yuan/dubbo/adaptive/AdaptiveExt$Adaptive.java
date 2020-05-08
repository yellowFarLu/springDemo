/*
 * 自适应扩展机制生成的代理对象的代码
 */
//package com.huang.yuan.dubbo.adaptive;
//
//import com.alibaba.dubbo.common.extension.ExtensionLoader;
//
//public class AdaptiveExt$Adaptive implements com.huang.yuan.dubbo.adaptive.AdaptiveExt {
//    public java.lang.String echo(java.lang.String arg0, com.alibaba.dubbo.common.URL arg1) {
//        if (arg1 == null)
//            throw new IllegalArgumentException("url == null");
//
//        com.alibaba.dubbo.common.URL url = arg1;
//
//        // 所以url中要由adaptive.ext来指定要加载的扩展名
//        String extName = url.getParameter("adaptive.ext");
//
//        if(extName == null)
//            throw new IllegalStateException("Fail to get extension(com.huang.yuan.dubbo.adaptive.AdaptiveExt) name from url(" + url.toString() + ") use keys([adaptive.ext])");
//
//        com.huang.yuan.dubbo.adaptive.AdaptiveExt extension =
//                (com.huang.yuan.dubbo.adaptive.AdaptiveExt)ExtensionLoader.
//                        getExtensionLoader(com.huang.yuan.dubbo.adaptive.AdaptiveExt.class).getExtension(extName);
//
//        return extension.echo(arg0, arg1);
//    }
//}


package com.huang.yuan.dubbo.adaptive;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class AdaptiveExt$Adaptive implements com.huang.yuan.dubbo.adaptive.AdaptiveExt {
    public java.lang.String echo(java.lang.String arg0, com.alibaba.dubbo.common.URL arg1) {
        if (arg1 == null)
            throw new IllegalArgumentException("url == null");

        com.alibaba.dubbo.common.URL url = arg1;
        String extName = url.getParameter("test");
        if(extName == null)
            throw new IllegalStateException(
                    "Fail to get extension(com.huang.yuan.dubbo.adaptive.AdaptiveExt) name from url(" + url.toString() + ") use keys([test])");

        com.huang.yuan.dubbo.adaptive.AdaptiveExt extension =
                (com.huang.yuan.dubbo.adaptive.AdaptiveExt)ExtensionLoader.
                        getExtensionLoader(com.huang.yuan.dubbo.adaptive.AdaptiveExt.class).getExtension(extName);
        return extension.echo(arg0, arg1);
    }
}