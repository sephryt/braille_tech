/*
package com.experiment.anotherproject;

public class extra {

    */
/*
8 11
9 12
10 13
OFF = 000000 = 0; Inverted = 111111 = 63;
A = 100000 = 32; Inverted = 011111 = 31
B = 110000 = 48; Inverted = 001111 = 15
C = 100100 = 36; Inverted = 011011 = 27
D = 100110 = 38; Inverted = 011001 = 25;
E = 100010 = 34; Inverted = 011101 = 29;
F = 110100 = 52; Inverted = 001011 = 11;
G = 110110 = 54; Inverted = 001001 = 9;
H = 110010 = 50; Inverted = 001101 = 13;
I = 010100 = 20; Inverted = 101011 = 43;
J = 010110 = 22; Inverted = 101001 = 41;
K = 101000 = 40; Inverted = 010111 = 23;
L = 111000 = 56; Inverted = 000111 = 7;
M = 101100 = 44; Inverted = 010011 = 19;
N = 101110 = 46; Inverted = 010001 = 17;
O = 101010 = 42; Inverted = 010101 = 21;
P = 111100 = 60; Inverted = 000011 = 3;
Q = 111110 = 62; Inverted = 000001 = 1;
R = 111010 = 58; Inverted = 000101 = 5;
S = 011100 = 28; Inverted = 100011 = 35;
T = 011110 = 30; Inverted = 100001 = 33;
U = 101001 = 41; Inverted = 010110 = 63;
V = 111001 = 57; Inverted = 000110 = 6;
W = 010111 = 23; Inverted = 101000 = 40;
X = 101101 = 45; Inverted = 010010 = 18;
Y = 101111 = 47; Inverted = 010000 = 16;
Z = 101011 = 43; Inverted = 010100 = 20;

First set = 001111 =15; Inverted = 110000 = 48
1 = 100000 = 32; Inverted = 011111 = 31
2 = 110000 = 48; Inverted = 001111 = 15
3 = 100100 = 36; Inverted = 011011 = 27
4 = 100110 = 38; Inverted = 011001 = 25;
5 = 100010 = 34; Inverted = 011101 = 29;
6 = 110100 = 52; Inverted = 001011 = 11;
7 = 110110 = 54; Inverted = 001001 = 9;
8 = 110010 = 50; Inverted = 001101 = 13;
9 = 010100 = 20; Inverted = 101011 = 43;
0 = 010110 = 22; Inverted = 101001 = 41;
*//*

#include <CapacitiveSensor.h>
    CapacitiveSensor   cs_4_6 = CapacitiveSensor(3,4);
    long int data, tmp;
    String offActuator;
    int trigger;
    int out[] ={13,12,11,10,9,8};
    long int lettera=01;//a
    long int letterb=02;//b
    long int letterc=03;//c
    long int letterd=04;//d
    long int lettere=05;//e
    long int letterf=06;//f
    long int letterg=07;//g
    long int letterh=8;//h
    long int letteri=9;//i
    long int letterj=10;//j
    long int letterk=11;//k
    long int letterl=12;//l
    long int letterm=13;//m
    long int lettern=14;//n
    long int lettero=15;//o
    long int letterp=16;//p
    long int letterq=17;//q
    long int letterr=18;//r
    long int letters=19;//s
    long int lettert=20;//t
    long int letteru=21;//u
    long int letterv=22;//v
    long int letterw=23;//w
    long int letterx=24;//x
    long int lettery=25;//y
    long int letterz=26;//z

    long int numone=31;//1
    long int numtwo=32;//2
    long int numthree=33;//3
    long int numfour=34;//4
    long int numfive=35;//5
    long int numsix=36;//6
    long int numseven=37;//7
    long int numeight=38;//8
    long int numnine=39;//9
    long int numzero=30;//0
    void setup()
    {
        for(int i=0; i<6; i++){
            pinMode(out[i], OUTPUT);
        }
        cs_4_6.set_CS_AutocaL_Millis(0xFFFFFFFF);
        for(int i=0;i<6;i++){
            digitalWrite(out[i], 1);
        }
        Serial.begin(9600);
    }
    long touchVal;
    void loop()
    {

        long start = millis();
        touchVal =  cs_4_6.capacitiveSensor(30);
        if(Serial.read()=="OFF") offActuator == "OFF";
        else {
            data= Serial.parseInt();
            tmp = data;
        }
        if(tmp == lettera){
            actuatorLetterValue(31);
            if(offActuator == "OFF"){
                offActuator = "";
            }
            trigger =1;
        }
        if(data == letterb){
            actuatorLetterValue(15);
            trigger=2;
        }
        if(data == letterc){
            actuatorLetterValue(27);
            trigger=3;
        }
        if(data == letterd){
            actuatorLetterValue(25);
            trigger=4;
        }
        if(data == lettere){
            actuatorLetterValue(29);
            trigger=5;
        }
        if(data == letterf){
            actuatorLetterValue(11);
            trigger=6;
        }
        if(data == letterg){
            actuatorLetterValue(9);
            trigger=7;
        }
        if(data == letterh){
            actuatorLetterValue(13);
            trigger=8;
        }
        if(data == letteri){
            actuatorLetterValue(43);
            trigger=9;
        }
        if(data == letterj){
            actuatorLetterValue(41);
            trigger=10;
        }
        if(data == letterk){
            actuatorLetterValue(23);
            trigger=11;
        }
        if(data == letterl){
            actuatorLetterValue(7);
            trigger=12;
        }
        if(data == letterm){
            actuatorLetterValue(19);
            trigger=13;
        }
        if(data == lettern){
            actuatorLetterValue(17);
            trigger=14;
        }
        if(data == lettero){
            actuatorLetterValue(21);
            trigger=15;
        }
        if(data == letterp){
            actuatorLetterValue(3);
            trigger=16;
        }
        if(data == letterq){
            actuatorLetterValue(1);
            trigger=17;
        }
        if(data == letterr){
            actuatorLetterValue(5);
            trigger=18;
        }
        if(data == letters){
            actuatorLetterValue(35);
            trigger=19;
        }
        if(data == lettert){
            actuatorLetterValue(33);
            trigger=20;
        }
        if(data == letteru){
            actuatorLetterValue(22);
            trigger=21;
        }
        if(data == letterv){
            actuatorLetterValue(6);
            trigger=22;
        }
        if(data == letterw){
            actuatorLetterValue(40);
            trigger=23;
        }
        if(data == letterx){
            actuatorLetterValue(18);
            trigger=24;
        }
        if(data == lettery){
            actuatorLetterValue(16);
            trigger=25;
        }
        if(data == letterz){
            actuatorLetterValue(20);
            trigger=26;
        }
        if(data == numzero){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(41);
            trigger=30;
        }
        if(data == numone){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(31);
            trigger=31;
        }
        if(data == numtwo){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(15);
            trigger=32;
        }
        if(data == numthree){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(27);
            trigger=33;
        }
        if(data == numfour){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(25);
            trigger=34;
        }
        if(data == numfive){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(29);
            trigger=35;
        }
        if(data == numsix){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(11);
            trigger=36;
        }
        if(data == numseven){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(9);
            trigger=37;
        }
        if(data == numeight){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(13);
            trigger=38;
        }
        if(data == numnine){
            actuatorLetterValue(48);
            delay(3000);
            actuatorLetterValue(48);
            delay(500);
            actuatorLetterValue(43);
            trigger=39;
        }

        if(touchVal>190){
            Serial.println("7");
            switch(trigger){
                case 1:
                    delay(3000);
                    actuatorLetterValue(31);
                    trigger=0;
                    break;
                case 2:
                    delay(3000);
                    actuatorLetterValue(15);
                    trigger=0;
                    break;
                case 3:
                    delay(3000);
                    actuatorLetterValue(27);
                    trigger=0;
                    break;
                case 4:
                    delay(3000);
                    actuatorLetterValue(25);
                    trigger=0;
                    break;
                case 5:
                    delay(3000);
                    actuatorLetterValue(29);
                    trigger=0;
                    break;
                case 6:
                    delay(3000);
                    actuatorLetterValue(11);
                    trigger=0;
                    break;
                case 7:
                    delay(3000);
                    actuatorLetterValue(9);
                    trigger=0;
                    break;
                case 8:
                    delay(3000);
                    actuatorLetterValue(13);
                    trigger=0;
                    break;
                case 9:
                    delay(3000);
                    actuatorLetterValue(43);
                    trigger=0;
                    break;
                case 10:
                    delay(3000);
                    actuatorLetterValue(41);
                    trigger=0;
                    break;
                case 11:
                    delay(3000);
                    actuatorLetterValue(23);
                    trigger=0;
                    break;
                case 12:
                    delay(3000);
                    actuatorLetterValue(7);
                    trigger=0;
                    break;
                case 13:
                    delay(3000);
                    actuatorLetterValue(19);
                    trigger=0;
                    break;
                case 14:
                    delay(3000);
                    actuatorLetterValue(17);
                    trigger=0;
                    break;
                case 15:
                    delay(3000);
                    actuatorLetterValue(21);
                    trigger=0;
                    break;
                case 16:
                    delay(3000);
                    actuatorLetterValue(3);
                    trigger=0;
                    break;
                case 17:
                    delay(3000);
                    actuatorLetterValue(1);
                    trigger=0;
                    break;
                case 18:
                    delay(3000);
                    actuatorLetterValue(5);
                    trigger=0;
                    break;
                case 19:
                    delay(3000);
                    actuatorLetterValue(35);
                    trigger=0;
                    break;
                case 20:
                    delay(3000);
                    actuatorLetterValue(33);
                    trigger=0;
                    break;
                case 21:
                    actuatorLetterValue(63);
                    delay(500);
                    trigger=0;
                    break;
                case 22:
                   delay(3000);
                    actuatorLetterValue(6);
                    trigger=0;
                    break;
                case 23:
                    delay(3000);
                    actuatorLetterValue(40);
                    trigger=0;
                    break;
                case 24:
                    delay(3000);
                    actuatorLetterValue(18);
                    trigger=0;
                    break;
                case 25:
                    delay(3000);
                    actuatorLetterValue(16);
                    trigger=0;
                    break;
                case 26:
                    delay(3000);
                    actuatorLetterValue(20);
                    trigger=0;
                    break;
                case 30:
                    delay(3000);
                    actuatorLetterValue(41);
                    trigger=0;
                    break;
                case 31:
                    delay(3000);
                    actuatorLetterValue(31);
                    trigger=0;
                    break;
                case 32:
                    delay(3000);
                    actuatorLetterValue(15);
                    trigger=0;
                    break;
                case 33:
                    delay(3000);
                    actuatorLetterValue(27);
                    trigger=0;
                    break;
                case 34:
                    delay(3000);
                    actuatorLetterValue(25);
                    trigger=0;
                    break;
                case 35:
                    delay(3000);
                    actuatorLetterValue(29);
                    trigger=0;
                    break;
                case 36:
                    delay(3000);
                    actuatorLetterValue(11);
                    trigger=0;
                    break;
                case 37:
                    delay(3000);
                    actuatorLetterValue(9);
                    trigger=0;
                    break;
                case 38:
                    delay(3000);
                    actuatorLetterValue(13);
                    trigger=0;
                    break;
                case 39:
                    delay(3000);
                    actuatorLetterValue(43);
                    trigger=0;
                    break;
            }
        }
        delay(50);
    }
    void downActuator(){
        for(int i=0; i<6; i++){
            digitalWrite(out[i],1);
        }
    }
    void actuatorLetterValue(int divisor){
        for(int i=0; i<6; i++){
            digitalWrite(out[i], divisor%2);
            divisor = divisor/2;
        }
        delay(500);
        downActuator();
    }
}

if (resetCount==1){
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(41,2100,400);//0
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(31,2100,400);//1
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(15,2100,400);//2
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(27,2100,400);//3
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(25,2100,400);//4
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(29,2100,400);//5
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(11,2100,400);//6
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(9,2100,400);//7
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(13,2100,400);//8
              actuatorRefresh(48,2100,400);//#
              actuatorRefresh(43,2100,400);//9
            }
            if (resetAbc==1){
              actuatorRefresh(31,3500,500);//a
              actuatorRefresh(15,3500,500);//b
              actuatorRefresh(27,3500,500);//c
              actuatorRefresh(25,3500,500);//d
              actuatorRefresh(29,3500,500);//e
              actuatorRefresh(11,3500,500);//f
              actuatorRefresh(9,3500,500);//g
              actuatorRefresh(13,3500,500);//h
              actuatorRefresh(43,3500,500);//i
              actuatorRefresh(41,3500,500);//j
              actuatorRefresh(23,3500,500);//k
              actuatorRefresh(7,3500,500);//l
              actuatorRefresh(19,3500,500);//m
              actuatorRefresh(17,3500,500);//n
              actuatorRefresh(21,3500,500);//o
              actuatorRefresh(3,3500,500);//p
              actuatorRefresh(1,3500,500);//q
              actuatorRefresh(5,3500,500);//r
              actuatorRefresh(35,3500,500);//s
              actuatorRefresh(33,3500,500);//t
              actuatorRefresh(22,3500,500);//u
              actuatorRefresh(6,3500,500);//v
              actuatorRefresh(40,3500,500);//w
              actuatorRefresh(18,3500,500);//x
              actuatorRefresh(16,3500,500);//y
              actuatorRefresh(20,3500,500);//z
            }
            void childIN(int cnt){
           switch (cnt)
           {
              case 1:
              actuatorRefresh(31,3500,500);
              counter=cnt;
              break;
              case 2:
              actuatorRefresh(15,3500,500);//b
              counter=cnt;
              break;
              case 3:
              actuatorRefresh(27,3500,500);//c
              counter=cnt;
              break;
              case 4:
              actuatorRefresh(25,3500,500);//d
              counter=cnt;
              break;
              case 5:
              actuatorRefresh(29,3500,500);//e
              counter=cnt;
              break;
              case 6:
              actuatorRefresh(11,3500,500);//f
              counter=cnt;
              break;
              case 7:
              actuatorRefresh(9,3500,500);//g
              counter=cnt;
              break;
              case 8:
              actuatorRefresh(13,3500,500);//h
              counter=cnt;
              break;
              case 9:
              actuatorRefresh(43,3500,500);//i
              counter=cnt;
              break;
              case 10:
              actuatorRefresh(41,3500,500);//j
              counter=cnt;
              break;
              case 11:
              actuatorRefresh(23,3500,500);//k
              counter=cnt;
              break;
              case 12:
              actuatorRefresh(7,3500,500);//l
              counter=cnt;
              break;
              case 13:
              actuatorRefresh(19,3500,500);//m
              counter=cnt;
              break;
              case 14:
              actuatorRefresh(17,3500,500);//n
              counter=cnt;
              break;
              case 15:
              actuatorRefresh(21,3500,500);//o
              counter=cnt;
              break;
              case 16:
              actuatorRefresh(3,3500,500);//p
              counter=cnt;
              break;
              case 17:
              actuatorRefresh(1,3500,500);//q
              counter=cnt;
              break;
              case 18:
              actuatorRefresh(5,3500,500);//r
              counter=cnt;
              break;
              case 19:
              actuatorRefresh(35,3500,500);//s
              counter=cnt;
              break;
              case 20:
              actuatorRefresh(33,3500,500);//t
              counter=cnt;
              break;
              case 21:
              actuatorRefresh(22,3500,500);//u
              counter=cnt;
              break;
              case 22:
              actuatorRefresh(6,3500,500);//v
              counter=cnt;
              break;
              case 23:
              actuatorRefresh(40,3500,500);//w
              counter=cnt;
              break;
              case 24:
              actuatorRefresh(18,3500,500);//x
              counter=cnt;
              break;
              case 25:
              actuatorRefresh(16,3500,500);//y
              counter=cnt;
              break;
              case 26:
              actuatorRefresh(20,3500,500);//z
              counter=cnt;
              break;
              case 27:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(41,2100,400);//0
              counter=cnt;
              break;
              case 28:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(31,2100,400);//1
              counter=cnt;
              break;
              case 29:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(15,2100,400);//2
              counter=cnt;
              break;
              case 30:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(27,2100,400);//3
              counter=cnt;
              break;
              case 31:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(25,2100,400);//4
              counter=cnt;
              break;
              case 32:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(29,2100,400);//5
              counter=cnt;
              break;
              case 33:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(11,2100,400);//6
              counter=cnt;
              break;
              case 34:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(9,2100,400);//7
              counter=cnt;
              break;
              case 35:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(13,2100,400);//8
              counter=cnt;
              break;
              case 36:
              actuatorRefresh(48,2100,400);
              actuatorRefresh(43,2100,400);//9
              counter=cnt;
              break;
            }
      }
*/
