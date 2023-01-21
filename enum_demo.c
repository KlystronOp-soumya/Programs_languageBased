#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#define MAX_ELEM 100

#define GROUND 0
#define LOW 1
#define HIGH 2


int main(int argc,char*argv[])
{
enum VOLTAGE {ground=0,low=5,high=12} ;
 
 typedef struct MICROCONTROLLER{
     unsigned int pin;
     enum VOLTAGE pin_voltage;
 }micro_controller;
    micro_controller esp_232 ;
    esp_232.pin =1;
    esp_232.pin_voltage=high;

 printf("%d ",esp_232.pin_voltage) ;
return 0;
}