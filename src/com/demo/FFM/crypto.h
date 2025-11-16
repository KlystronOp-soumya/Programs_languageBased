#ifdef CRYPTO_H
#define CRYPTO_H

#include <stdio.h>
#include <stdint.h>

#ifdef _cplusplus
extern "C" {
#endif

void sha256(const uint8_t* input, int len, uint8_t* output);

#ifdef 	_cplusplus
}
#endif

#endif
