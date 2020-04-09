package com.yangzg.lesson7;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author Sam
 * @date 2020/3/29 2:46 PM
 */
public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        final ClassMetadata classMetadata = metadataReader.getClassMetadata();
        return Person.class.getName().equals(classMetadata.getClassName());
    }
}
