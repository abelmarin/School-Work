   0x0000000000400ad0 <+0>:	    push   %rbp
   0x0000000000400ad1 <+1>:	    push   %rbx
   0x0000000000400ad2 <+2>:	    mov    %esi,%ebx
   0x0000000000400ad4 <+4>:	    sub    $0x28,%rsp
   0x0000000000400ad8 <+8>:	    mov    %rsp,%rsi
   0x0000000000400adb <+11>:	callq  0x400c80 <read_six_numbers>
   0x0000000000400ae0 <+16>:	mov    (%rsp),%eax
   0x0000000000400ae3 <+19>:	cmp    %ebx,%eax
   0x0000000000400ae5 <+21>:	je     0x400af1 <phase_3+33>
   0x0000000000400ae7 <+23>:	xor    %eax,%eax
   0x0000000000400ae9 <+25>:	callq  0x400c60 <explode_bomb>
   0x0000000000400aee <+30>:	mov    (%rsp),%eax
   0x0000000000400af1 <+33>:	lea    0x4(%rsp),%rbx
   0x0000000000400af6 <+38>:	add    %eax,%eax
   0x0000000000400af8 <+40>:	lea    0x14(%rsp),%rbp
   0x0000000000400afd <+45>:	cmp    (%rbx),%eax
   0x0000000000400aff <+47>:	je     0x400b08 <phase_3+56>
   0x0000000000400b01 <+49>:	xor    %eax,%eax
   0x0000000000400b03 <+51>:	callq  0x400c60 <explode_bomb>
   0x0000000000400b08 <+56>:	cmp    %rbp,%rbx
   0x0000000000400b0b <+59>:	je     0x400b1e <phase_3+78>
   0x0000000000400b0d <+61>:	mov    (%rbx),%eax
   0x0000000000400b0f <+63>:	add    $0x4,%rbx
   0x0000000000400b13 <+67>:	add    %eax,%eax
   0x0000000000400b15 <+69>:	cmp    (%rbx),%eax
   0x0000000000400b17 <+71>:	jne    0x400b01 <phase_3+49>
   0x0000000000400b19 <+73>:	cmp    %rbp,%rbx
   0x0000000000400b1c <+76>:	jne    0x400b0d <phase_3+61>
   0x0000000000400b1e <+78>:	add    $0x28,%rsp
   0x0000000000400b22 <+82>:	pop    %rbx
   0x0000000000400b23 <+83>:	pop    %rbp
   0x0000000000400b24 <+84>:	retq   
