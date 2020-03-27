   0x0000000000400ba0 <+0>:	    push   %rbx
   0x0000000000400ba1 <+1>:	    xor    %eax,%eax
   0x0000000000400ba3 <+3>:	    mov    %esi,%ebx
   0x0000000000400ba5 <+5>:	    mov    $0x401189,%esi
   0x0000000000400baa <+10>:	sub    $0x10,%rsp
   0x0000000000400bae <+14>:	lea    0xc(%rsp),%rdx
   0x0000000000400bb3 <+19>:	callq  0x400670 <__isoc99_sscanf@plt>
   0x0000000000400bb8 <+24>:	test   %ebx,%ebx
   0x0000000000400bba <+26>:	jle    0x400c13 <phase_5+115>
   0x0000000000400bbc <+28>:	lea    0x1(%rbx),%edi
   0x0000000000400bbf <+31>:	xor    %esi,%esi
   0x0000000000400bc1 <+33>:	mov    $0x1,%edx
   0x0000000000400bc6 <+38>:	mov    $0x2,%ecx
   0x0000000000400bcb <+43>:	add    %edx,%esi
   0x0000000000400bcd <+45>:	cmp    %edi,%ecx
   0x0000000000400bcf <+47>:	je     0x400c00 <phase_5+96>
   0x0000000000400bd1 <+49>:	nopl   0x0(%rax)
   0x0000000000400bd8 <+56>:	cmp    $0x1,%ecx
   0x0000000000400bdb <+59>:	jle    0x400c17 <phase_5+119>
   0x0000000000400bdd <+61>:	add    $0x1,%ecx
   0x0000000000400be0 <+64>:	mov    $0x2,%eax
   0x0000000000400be5 <+69>:	mov    $0x1,%edx
   0x0000000000400bea <+74>:	nopw   0x0(%rax,%rax,1)
   0x0000000000400bf0 <+80>:	imul   %eax,%edx
   0x0000000000400bf3 <+83>:	add    $0x1,%eax
   0x0000000000400bf6 <+86>:	cmp    %ecx,%eax
   0x0000000000400bf8 <+88>:	jne    0x400bf0 <phase_5+80>
   0x0000000000400bfa <+90>:	add    %edx,%esi
   0x0000000000400bfc <+92>:	cmp    %edi,%ecx
   0x0000000000400bfe <+94>:	jne    0x400bd8 <phase_5+56>
   0x0000000000400c00 <+96>:	cmp    0xc(%rsp),%esi
   0x0000000000400c04 <+100>:	je     0x400c0d <phase_5+109>
   0x0000000000400c06 <+102>:	xor    %eax,%eax
   0x0000000000400c08 <+104>:	callq  0x400c60 <explode_bomb>
   0x0000000000400c0d <+109>:	add    $0x10,%rsp
   0x0000000000400c11 <+113>:	pop    %rbx
   0x0000000000400c12 <+114>:	retq   
   0x0000000000400c13 <+115>:	xor    %esi,%esi
   0x0000000000400c15 <+117>:	jmp    0x400c00 <phase_5+96>
   0x0000000000400c17 <+119>:	mov    $0x1,%edx
   0x0000000000400c1c <+124>:	add    $0x1,%ecx
   0x0000000000400c1f <+127>:	jmp    0x400bcb <phase_5+43>