package com.factorybean;

import com.model.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author huangy on 2019-10-27
 */
@Component
public class StudentFactoryBean implements FactoryBean<Student> {

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public Student getObject() throws Exception {
        return new Student("黄远");
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
