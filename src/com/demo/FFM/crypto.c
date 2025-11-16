#include "crypto.h"
#include <stdio.h>
#include <stdint.h>

void sha256(const uint8_t* input, int len, uint8_t* output) {
    // temporary dummy output to verify Java FFM integration works
    for (int i = 0; i < 32; i++) {
        output[i] = (uint8_t)(input[0] + i);
    }
}
