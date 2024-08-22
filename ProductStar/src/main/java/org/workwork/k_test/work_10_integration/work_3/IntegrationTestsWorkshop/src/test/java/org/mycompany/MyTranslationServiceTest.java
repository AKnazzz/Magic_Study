package org.workwork.k_test.work_10_integration.work_3.IntegrationTestsWorkshop.src.test.java.org.mycompany;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class MyTranslationServiceTest {

    @Mock
    private Translate translate;
    @Mock
    private Translation translation;

    @Test
    void translateWithGoogle_anySentenceAndTargetLanguageIsRu_success() {
        var myTranslationService = new MyTranslationService(translate);

        var sentence = "Some sentence";
        var targetLanguage = "ru";

        var expectedResult = "Какое-то предложение";

        Mockito.when(translate.translate(eq(sentence), any())).thenReturn(translation);
        Mockito.when(translation.getTranslatedText()).thenReturn(expectedResult);

        String actualResult = myTranslationService.translateWithGoogle(sentence, targetLanguage);

        assertEquals(expectedResult, actualResult);

        Mockito.verify(translate).translate(eq(sentence), any());
        Mockito.verifyNoMoreInteractions(translate);

        Mockito.verify(translation).getTranslatedText();
        Mockito.verifyNoMoreInteractions(translation);
    }

    @Test
    void translateWithGoogle_anySentenceAndTargetLanguageIsNotRu_failure() {
        var myTranslationService = new MyTranslationService(translate);

        var sentence = "Some sentence";
        var targetLanguage = "es";

        assertThrows(
                IllegalArgumentException.class,
                () -> myTranslationService.translateWithGoogle(sentence, targetLanguage)
        );

        Mockito.verifyNoInteractions(translate);
        Mockito.verifyNoInteractions(translation);
    }

    @Test
    void translateWithGoogle_googleTranslateThrowsException_failure() {
        var myTranslationService = new MyTranslationService(translate);

        var sentence = "Some sentence";
        var targetLanguage = "ru";

        Mockito.when(translate.translate(eq(sentence), any())).thenThrow(new RuntimeException());

        assertThrows(
                MyTranslationServiceException.class,
                () -> myTranslationService.translateWithGoogle(sentence, targetLanguage)
        );

        Mockito.verify(translate).translate(eq(sentence), any());
        Mockito.verifyNoMoreInteractions(translate);

        Mockito.verifyNoMoreInteractions(translation);
    }
}