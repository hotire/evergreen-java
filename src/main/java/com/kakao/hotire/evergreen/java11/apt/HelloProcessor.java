package com.kakao.hotire.evergreen.java11.apt;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

//@AutoService(Processor.class)
public class HelloProcessor extends AbstractProcessor {

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Hello.class.getName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        roundEnv.getElementsAnnotatedWith(Hello.class)
                .stream()
                .filter(this::checkElementType)
                .forEach(element -> {
                    // process
                });

        return false;
    }

    protected boolean checkElementType(Element element) {
        Name elementName = element.getSimpleName();
        if (element.getKind() != ElementKind.INTERFACE) {
            processingEnv.getMessager().printMessage(Kind.ERROR, "Hello annotation can not be used on " + elementName);
            return false;
        }

        processingEnv.getMessager().printMessage(Kind.NOTE, "Processing " + elementName);
        return true;
    }
}
