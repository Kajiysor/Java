#include "JNIHello.h"
#include <stdio.h>
JNIEXPORT void JNICALL Java_JNIHello_sayHello(JNIEnv *env, jobject obj){
    printf("Hello World!\n");
    return;
}