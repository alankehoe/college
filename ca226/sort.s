  .data
nums: .double 2.5, 1.8, 10025.234, -90.154, 0.1, -0.25, 100, 123, 50, 19.9, 28.28
result: .double 0
x:	.word 11

        .text
	dadd r1,r0,r0		; r1 = 0
	l.d f0,nums(r1)		; load first num
loop:	daddi r1,r1,8		; increment our array offset by 1 word (FP numbers are 64-bit)
	l.d f1,nums(r1)		; load second num
	
	slt f3,f1,f0
	movn f2,f1,f3
	dsubi r3,r3,r1
	bnez r3,loop

halt