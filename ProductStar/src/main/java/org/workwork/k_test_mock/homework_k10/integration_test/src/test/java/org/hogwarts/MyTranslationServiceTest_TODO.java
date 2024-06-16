package org.hogwarts;


import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class MyTranslationServiceTest_TODO {
    @Mock
    private Translate googleTranslate;

    @Mock
    private Translation googleTranslateResult;

    /**
     * 1. Happy case test.
     * <p>
     * When `MyTranslationService::translateWithGoogle` method is called with any sentence and target language is equal to "ru",
     * `googleTranslate` dependency should be called and `translation.getTranslatedText()` returned.
     * No other interactions with `googleTranslate` dependency should be invoked apart from a single call to `googleTranslate.translate()`.
     */
    @Test
    void translateWithGoogle_anySentenceAndTargetLanguageIsRu_success() {

        MyTranslationService myTranslationService = new MyTranslationService(googleTranslate);
        String sentence = "Some sentence";
        String targetLanguage = "ru";
        String expectedTranslation = "Некое предложение";


        Mockito.when(googleTranslate.translate(eq(sentence), ArgumentMatchers.any())).thenReturn(googleTranslateResult);
        Mockito.when(googleTranslateResult.getTranslatedText()).thenReturn(expectedTranslation);

        String result = myTranslationService.translateWithGoogle(sentence, targetLanguage);
        assertEquals(expectedTranslation, result);

        Mockito.verify(googleTranslate).translate(eq(sentence), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(googleTranslate);

        Mockito.verify(googleTranslateResult).getTranslatedText();
        Mockito.verifyNoMoreInteractions(googleTranslateResult);

        Mockito.verify(googleTranslate, times(1)).translate(eq(sentence), any());
        Mockito.verify(googleTranslateResult, times(1)).getTranslatedText();

    }

    /**
     * 2. Unhappy case test when target language is not supported.
     * <p>
     * When `MyTranslationService::translateWithGoogle` method is called with any sentence and target language is not equal to "ru",
     * `IllegalArgumentException` should be thrown. `googleTranslate` dependency should not be called at all.
     */
    @Test
    void translateWithGoogle_anySentenceAndTargetLanguageIsNotRu_failure() {

        MyTranslationService myTranslationService = new MyTranslationService(googleTranslate);
        String sentence = "Some sentence";
        String targetLanguage = "es";

        assertThrows(
                IllegalArgumentException.class,
                () -> myTranslationService.translateWithGoogle(sentence, targetLanguage)
        );
        Mockito.verifyNoInteractions(googleTranslate);
        Mockito.verifyNoInteractions(googleTranslateResult);
    }

    /**
     * 3. Unhappy case test when Google Translate call throws exception.
     * <p>
     * When `MyTranslationService::translateWithGoogle` method is called with any sentence and target language is equal to "ru",
     * `googleTranslate` dependency should be called. When `googleTranslate` dependency throws exception, it should be
     * wrapped into `MyTranslationServiceException` and the latter should be thrown from our method.
     */
    @Test
    void translateWithGoogle_googleTranslateThrowsException_failure() {
        MyTranslationService myTranslationService = new MyTranslationService(googleTranslate);
        String sentence = "Some sentence";
        String targetLanguage = "ru";

        Mockito.when(googleTranslate.translate(eq(sentence), ArgumentMatchers.any())).thenThrow(new RuntimeException());

        assertThrows(
                MyTranslationServiceException.class,
                () -> myTranslationService.translateWithGoogle(sentence, targetLanguage)
        );
        Mockito.verify(googleTranslate).translate(eq(sentence), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(googleTranslate);
        Mockito.verifyNoInteractions(googleTranslateResult);

        Mockito.verify(googleTranslate, times(1)).translate(eq(sentence), any());
        Mockito.verifyNoInteractions(googleTranslateResult);
    }

}