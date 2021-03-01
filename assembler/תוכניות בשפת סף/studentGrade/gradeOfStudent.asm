.MODEL SMALL
.STACK 100H
.DATA
startStr DB 'what is your grade?',13,10,'$'
bestStr DB 'you are the best',13,10,'$'
goodStr DB 'you are good',13,10,'$'
tryStr DB 'Try to get more...',13,10,'$'
grade DW ?
ten DW 10

.CODE
main:
	MOV AX,@DATA
	MOV DS,AX
	
	;הדפסת השאלה למסך
	MOV AH,9
	MOV DX,OFFSET startStr
	INT 21h
	
	;read input
	MOV AH,1
	INT 21h;return the result to AL
	SUB AL,'0';אנחנו קיבלנו את התו 9 אך אנחנו נרצה את המספר ולכן  נוריד את ההתחלה כלומר את התו 0
	MOV AH,0
	;נאפס את החלק העליון על מנת שנוכל אחר כך להעביר
	;את אוגר AX
	;אנחנו חיביים להעביר את אוגר זה כיוון שהגדרנו את הציון בגודל של 16 בתים אז חייב להעביר אליו 16 בתים
	MOV grade,AX
	
	MOV AH,1;נקלוט עוד תו
	INT 21h
	CMP AL,13;אם התו הוא אנטר
	JE endInput;נקפוץ למקום שנקרא סיום הקלט
	;אם זה לא אנטר אז נחסר ממנו את התו 0 על מנת שנדע מהי הספרה
	SUB AL,'0'
	MOV CL,AL;נשמור רגע את הספרה החדשה בצד
	MOV AX, grade;נשים את הציון באיי איקס כי פעולת הכפל עובדת על האוגר איי אל ושמה את התוצאה הרי באיי איקס
	MUL ten;לאחר שהציון באיי אל נכפיל אותו ב 10 ונשים את התוצאה באיי איקס
	MOV grade,AX;נעביר חזרה לציון את מה שיצא
	MOV CH,0;על מנת להוסיף את הספרה החדשה נצטרך לאפס את החלק העליון של האוגר
	ADD grade,CX;נוסיף את הספרה החדשה לציון
	
	MOV AH,1;נקלוט עוד תו
	INT 21h
	CMP AL,13
	JE endInput
	SUB AL,'0'
	MOV CL,AL;נשמור רגע את הספרה החדשה בצד
	MOV AX, grade;נשים את הציון באיי איקס כי פעולת הכפל עובדת על האוגר איי אל ושמה את התוצאה הרי באיי איקס
	MUL ten;לאחר שהציון באיי אל נכפיל אותו ב 10 ונשים את התוצאה באיי איקס
	MOV grade,AX;נעביר חזרה לציון את מה שיצא
	MOV CH,0;על מנת להוסיף את הספרה החדשה נצטרך לאפס את החלק העליון של האוגר
	ADD grade,CX
	
	endInput:
	CMP grade,90
	JA above90
	;below or equal 90
	MOV DX,OFFSET tryStr
	JMP printStr
	
	above90:;אם הציון מעל 90 או שווה ל90 כי שאלנו על מעל 90
	CMP grade,100
	JE hundred
	MOV DX,OFFSET goodStr
	JMP printStr
	
	hundred:;אם הציון הוא 100
	MOV DX,OFFSET bestStr
	
	;הדפסת המחרוזת המתאימה הנמצאת באיי איקס
	printStr:
	MOV AH,9
	INT 21h
	
	MOV AH,4Ch
	INT 21h
	
	END main
	
	
	
	
	
	