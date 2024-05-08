#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

char* decodeCaesarCipher(char *text, int shift) {
    char *result = malloc(sizeof(char) * (strlen(text) + 1));

    if (result == NULL) {
        perror("Failed to allocate memory");
        return NULL;
    }

    for (int i = 0; text[i] != '\0'; i++) {
        if (isalpha(text[i])) {
            char base = islower(text[i]) ? 'a' : 'A';
            int shifted = (text[i] - base - shift) % 26;
            if (shifted < 0)
                shifted += 26;
            result[i] = base + shifted;
        } else {
            result[i] = text[i];
        }
    }
    result[strlen(text)] = '\0';

    return result;
}

char *encodeCaesarCipher(char *text, int shift) {
    char *result = malloc(sizeof(char) * (strlen(text) + 1));

    if (result == NULL) {
        perror("Failed to allocate memory");
        return NULL;
    }

    for (int i = 0; text[i] != '\0'; i++) {
        if (isalpha(text[i])) {
            char base = islower(text[i]) ? 'a' : 'A';
            int shifted = (text[i] - base + shift) % 26;
            result[i] = base + shifted;
        } else {
            result[i] = text[i];
        }
    }
    result[strlen(text)] = '\0';

    return result;
}

int main(int argc, char **argv) {
    int shift = 3;

    if (argc != 3) {
        printf("Usage: %s <d|e> <text>\n", argv[0]);
        return 1;
    }

    char mode = argv[1][0];

    if (mode == 'd') {
        char *decoded_text = decodeCaesarCipher(argv[2], shift);
        if (decoded_text != NULL) {
            printf("Decoded Text: %s\n", decoded_text);
            free(decoded_text);
        }
    } else if (mode == 'e') {
        char *encoded_text = encodeCaesarCipher(argv[2], shift);
        if (encoded_text != NULL) {
            printf("Encoded Text: %s\n", encoded_text);
            free(encoded_text);
        }
    } else {
        printf("Usage: %s <d|e> <text>\n", argv[0]);
        return 1;
    }

    return 0;
}

/**
 * To run : gcc decode_caesar_cipher.c
 * To exec : ./a.out «zhoo grqh»
 * 
 * Coded by Loïc Rouzaud
 */