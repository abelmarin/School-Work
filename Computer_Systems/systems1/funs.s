	.file	"funs.c"
	.text
	.p2align 4,,15
	.globl	f0
	.type	f0, @function
f0:
.LFB14:
	.cfi_startproc
	movl	%edi, %eax
	imull	%edi, %eax
	ret
	.cfi_endproc
.LFE14:
	.size	f0, .-f0
	.p2align 4,,15
	.globl	f1
	.type	f1, @function
f1:
.LFB15:
	.cfi_startproc
	leal	(%rdi,%rsi), %eax
	ret
	.cfi_endproc
.LFE15:
	.size	f1, .-f1
	.p2align 4,,15
	.globl	f1a
	.type	f1a, @function
f1a:
.LFB16:
	.cfi_startproc
	addl	$1, (%rdi)
	ret
	.cfi_endproc
.LFE16:
	.size	f1a, .-f1a
	.p2align 4,,15
	.globl	f2
	.type	f2, @function
f2:
.LFB17:
	.cfi_startproc
	sall	$1, (%rdi)
	ret
	.cfi_endproc
.LFE17:
	.size	f2, .-f2
	.p2align 4,,15
	.globl	f3
	.type	f3, @function
f3:
.LFB18:
	.cfi_startproc
	cmpl	%edx, %edi
	sete	%dl
	xorl	%eax, %eax
	cmpl	%esi, %edi
	sete	%al
	andl	%edx, %eax
	ret
	.cfi_endproc
.LFE18:
	.size	f3, .-f3
	.p2align 4,,15
	.globl	f4
	.type	f4, @function
f4:
.LFB19:
	.cfi_startproc
	xorl	%eax, %eax
	cmpb	%sil, %dil
	sete	%al
	ret
	.cfi_endproc
.LFE19:
	.size	f4, .-f4
	.p2align 4,,15
	.globl	f5
	.type	f5, @function
f5:
.LFB20:
	.cfi_startproc
	cmpl	%esi, %edi
	movl	%esi, %eax
	cmovge	%edi, %eax
	ret
	.cfi_endproc
.LFE20:
	.size	f5, .-f5
	.p2align 4,,15
	.globl	f6
	.type	f6, @function
f6:
.LFB21:
	.cfi_startproc
	leal	(%rdx,%rcx), %eax
	addl	%esi, %eax
	addl	%edi, %eax
	shrl	$2, %eax
	ret
	.cfi_endproc
.LFE21:
	.size	f6, .-f6
	.p2align 4,,15
	.globl	f7
	.type	f7, @function
f7:
.LFB22:
	.cfi_startproc
	xorl	%eax, %eax
	movslq	%eax, %rdx
	cmpb	$0, (%rdi,%rdx)
	je	.L10
	addq	$1, %rdi
	.p2align 4,,10
	.p2align 3
.L11:
	addq	$1, %rdi
	addl	$1, %eax
	cmpb	$0, -1(%rdi)
	jne	.L11
.L10:
	rep ret
	.cfi_endproc
.LFE22:
	.size	f7, .-f7
	.p2align 4,,15
	.globl	f8
	.type	f8, @function
f8:
.LFB23:
	.cfi_startproc
	xorl	%eax, %eax
	testl	%esi, %esi
	jle	.L15
	.p2align 4,,10
	.p2align 3
.L17:
	movl	%eax, (%rdi,%rax,4)
	addq	$1, %rax
	cmpl	%eax, %esi
	jg	.L17
.L15:
	xorl	%eax, %eax
	ret
	.cfi_endproc
.LFE23:
	.size	f8, .-f8
	.p2align 4,,15
	.globl	f9
	.type	f9, @function
f9:
.LFB24:
	.cfi_startproc
	cmpl	$1, %esi
	movl	(%rdi), %eax
	jle	.L23
	movl	4(%rdi), %ecx
	leal	-1(%rcx), %edx
	cmpl	%eax, %edx
	jne	.L25
	leal	-2(%rsi), %eax
	addq	$8, %rdi
	leaq	(%rdi,%rax,4), %rcx
	jmp	.L21
	.p2align 4,,10
	.p2align 3
.L22:
	movl	(%rdi), %eax
	addq	$4, %rdi
	subl	$1, %eax
	cmpl	%edx, %eax
	jne	.L25
.L21:
	cmpq	%rcx, %rdi
	jne	.L22
.L23:
	movl	$1, %eax
	ret
	.p2align 4,,10
	.p2align 3
.L25:
	xorl	%eax, %eax
	ret
	.cfi_endproc
.LFE24:
	.size	f9, .-f9
	.ident	"GCC: (GNU) 4.8.5 20150623 (Red Hat 4.8.5-39)"
	.section	.note.GNU-stack,"",@progbits
