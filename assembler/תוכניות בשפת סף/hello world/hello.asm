.MODEL SMALL
.STACK 100h
.DATA

hellomsg DB 13, 10, 'hello world', 13, 10, '$'

.code
main:
    MOV AX,@DATA
    MOV DS,AX
    
    MOV AH,9
    MOV DX, OFFSET hellomsg
    INT 21h
    
    MOV AH,4Ch
    INT 21H
    
    END main
