.model small
.stack 100h
.DATA
     NUM1 DB 39h
     NUM2 DB 37h
     RESULT DB ?
 
.CODE
START:
      MOV AX,@DATA
      MOV DS,AX
 
      MOV AL,NUM1
      ADD AL,NUM2
      
      MOV AH,2
      MOV RESULT,AL 
      INT 21h
      
      MOV AH,4CH
      INT 21H      
      END START