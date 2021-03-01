.model small
.stack 100h
.DATA
     NUM1 DD 2000
     NUM2 DD 1000
     RES DD ?
 
.CODE
START:
      MOV AX,@DATA
      MOV DS,AX
 
      MOV AX ,WORD PTR NUM1
      ADD AX,WORD PTR NUM2
      MOV WORD PTR RES, AX
      
      MOV AX, WORD PTR NUM1+2
      ADC AX, WORD PTR NUM2+2
      MOV WORD PTR RES+2,AX
      
      MOV AH,9
      INT 21h
      
      MOV AH,4CH
      INT 21H      
      END START