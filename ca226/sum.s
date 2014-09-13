    .data	
a:    .double 3
    
    .text
    l.d f1,a(r0)
    mul.d f2,f1,f1
    halt
