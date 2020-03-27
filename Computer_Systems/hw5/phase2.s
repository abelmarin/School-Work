   0x0000000000400a70 <+0>:	    push   %rbx
   0x0000000000400a71 <+1>:	    xor    %eax,%eax
   0x0000000000400a73 <+3>:	    mov    %esi,%ebx
   0x0000000000400a75 <+5>:	    mov    $0x40116e,%esi
   0x0000000000400a7a <+10>:	add    $0x61,%ebx
   0x0000000000400a7d <+13>:	sub    $0x10,%rsp
   0x0000000000400a81 <+17>:	lea    0xc(%rsp),%r8
   0x0000000000400a86 <+22>:	lea    0x8(%rsp),%rcx
   0x0000000000400a8b <+27>:	lea    0x7(%rsp),%rdx
   0x0000000000400a90 <+32>:	callq  0x400670 <__isoc99_sscanf@plt>
   0x0000000000400a95 <+37>:	movsbl 0x7(%rsp),%eax
   0x0000000000400a9a <+42>:	cmp    %bl,%al
   0x0000000000400a9c <+44>:	je     0x400aaa <phase_2+58>
   0x0000000000400a9e <+46>:	xor    %eax,%eax
   0x0000000000400aa0 <+48>:	callq  0x400c60 <explode_bomb>
   0x0000000000400aa5 <+53>:	movsbl 0x7(%rsp),%eax
   0x0000000000400aaa <+58>:	cmp    0x8(%rsp),%eax
   0x0000000000400aae <+62>:	je     0x400ac0 <phase_2+80>
   0x0000000000400ab0 <+64>:	xor    %eax,%eax
   0x0000000000400ab2 <+66>:	callq  0x400c60 <explode_bomb>
   0x0000000000400ab7 <+71>:	add    $0x10,%rsp
   0x0000000000400abb <+75>:	pop    %rbx
   0x0000000000400abc <+76>:	retq   
   0x0000000000400abd <+77>:	nopl   (%rax)
   0x0000000000400ac0 <+80>:	cmp    0xc(%rsp),%eax
   0x0000000000400ac4 <+84>:	jne    0x400ab0 <phase_2+64>
   0x0000000000400ac6 <+86>:	jmp    0x400ab7 <phase_2+71>