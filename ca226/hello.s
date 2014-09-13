; Omf 2012-02-27
;
; original cycles: 1794
; orig. instructions: 1028
; orig. CPI 1.745
; orig. RAW stalls: 445
; orig. branch taken stalls: 317
; orig. code size: 60 bytes
;
; new cycles: 536
; insns: 491
; CPI: 1.092
; RAW stalls: 0
; branch taken stalls: 41
; code size: 148
;
; Hailstone numbers iteration
; If number is odd, multiply by 3 and add 1
; If number is even, divide it by 2
; repeat this iteration until number is 1 
;

        .data
number: .word 27          ; 27 produces max 0x2410
max:    .word 0           ; max number so far

        .text
start:  ld r1,number(r0)  ; program start
        daddi r7,r0,1     ; r7=1 ... used to check if we're finished later
        andi r3,r1,1      ; test odd or even
        dadd r4,r0,r1     ; set initial max to r1?
        beqz r3,even
odd:    dadd r2,r1,r1
        dadd r1,r2,r1     ; r1 = r2 + r1 = (r1 + r1) + r1 = 3*r1
        daddi r1,r1,1     ; r1++
        ; can only find new max if we had an odd number (we reduce even nums)
        slt r3,r4,r1      ; compare with max
        movn r4,r1,r3     ; save num if new max (conditional move)
        ; guaranteed to create an even number after an odd one, so...
        ; don't bother testing oddness, just drop through.
        ; also, we can't be finished here, so don't check
even:   dsrl r1,r1,1      ; /2
        andi r6,r1,1      ; test odd or even
        beq r7,r1,end     ; end if r7=1
        bnez r6,odd
        ; since we've just divided by 2, we can't have a new max
        ; so don't check

        ; unroll 2
        dsrl r1,r1,1      ; /2
        andi r6,r1,1      ; test odd or even
        beq r7,r1,end     ; end if r7==1
        bnez r6,odd

        ; unroll 3
        dsrl r1,r1,1      ; /2
        andi r6,r1,1      ; test odd or even
        beq r7,r1,end     ; end if r7==1
        bnez r6,odd

        ; unroll 4
        dsrl r1,r1,1      ; /2
        andi r6,r1,1      ; test odd or even
        beq r7,r1,end     ; end if r7==1
        bnez r6,odd

        ; unroll 5
        dsrl r1,r1,1      ; /2
        andi r6,r1,1      ; test odd or even
        beq r7,r1,end     ; end if r7==1
        bnez r6,odd

        ; unroll 6
        dsrl r1,r1,1      ; /2
        andi r6,r1,1      ; test odd or even
        beq r7,r1,end     ; end if r7==1
        bnez r6,odd
        j even            ; that's enough unrolling, loop

end:    sd r4,max(r0)     ; store the max found
        halt
