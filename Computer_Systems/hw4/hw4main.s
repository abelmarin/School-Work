	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 10, 15	sdk_version 10, 15
	.globl	_reverse                ## -- Begin function reverse
	.p2align	4, 0x90
_reverse:                               ## @reverse
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movl	%esi, -12(%rbp)
	movq	-8(%rbp), %rdi
	movq	%rdi, -24(%rbp)
	movq	-8(%rbp), %rdi
	movslq	-12(%rbp), %rax
	shlq	$2, %rax
	addq	%rax, %rdi
	addq	$-4, %rdi
	movq	%rdi, -32(%rbp)
LBB0_1:                                 ## =>This Inner Loop Header: Depth=1
	movq	-24(%rbp), %rax
	cmpq	-32(%rbp), %rax
	jb	LBB0_3
## %bb.2:
	jmp	LBB0_4
LBB0_3:                                 ##   in Loop: Header=BB0_1 Depth=1
	movq	-24(%rbp), %rax
	movl	(%rax), %ecx
	movl	%ecx, -36(%rbp)
	movq	-32(%rbp), %rax
	movl	(%rax), %ecx
	movq	-24(%rbp), %rax
	movl	%ecx, (%rax)
	movl	-36(%rbp), %ecx
	movq	-32(%rbp), %rax
	movl	%ecx, (%rax)
	movq	-24(%rbp), %rax
	addq	$4, %rax
	movq	%rax, -24(%rbp)
	movq	-32(%rbp), %rax
	addq	$-4, %rax
	movq	%rax, -32(%rbp)
	jmp	LBB0_1
LBB0_4:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_max                    ## -- Begin function max
	.p2align	4, 0x90
_max:                                   ## @max
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movl	%esi, -12(%rbp)
	movl	$0, -16(%rbp)
	cmpl	$0, -12(%rbp)
	jg	LBB1_2
## %bb.1:
	jmp	LBB1_9
LBB1_2:
	movq	-8(%rbp), %rax
	movl	(%rax), %ecx
	movl	%ecx, -16(%rbp)
	movl	$0, -20(%rbp)
LBB1_3:                                 ## =>This Inner Loop Header: Depth=1
	movl	-20(%rbp), %eax
	cmpl	-12(%rbp), %eax
	jl	LBB1_5
## %bb.4:
	jmp	LBB1_9
LBB1_5:                                 ##   in Loop: Header=BB1_3 Depth=1
	movq	-8(%rbp), %rax
	movl	(%rax), %ecx
	cmpl	-16(%rbp), %ecx
	jle	LBB1_7
## %bb.6:                               ##   in Loop: Header=BB1_3 Depth=1
	jmp	LBB1_8
LBB1_7:                                 ##   in Loop: Header=BB1_3 Depth=1
	movl	-20(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -20(%rbp)
	movq	-8(%rbp), %rcx
	addq	$4, %rcx
	movq	%rcx, -8(%rbp)
	jmp	LBB1_3
LBB1_8:                                 ##   in Loop: Header=BB1_3 Depth=1
	movq	-8(%rbp), %rax
	movl	(%rax), %ecx
	movl	%ecx, -16(%rbp)
	jmp	LBB1_3
LBB1_9:
	movl	-16(%rbp), %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_strcpy373              ## -- Begin function strcpy373
	.p2align	4, 0x90
_strcpy373:                             ## @strcpy373
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
LBB2_1:                                 ## =>This Inner Loop Header: Depth=1
	movq	-16(%rbp), %rax
	movsbl	(%rax), %ecx
	cmpl	$0, %ecx
	jne	LBB2_3
## %bb.2:
	jmp	LBB2_4
LBB2_3:                                 ##   in Loop: Header=BB2_1 Depth=1
	movq	-16(%rbp), %rax
	movb	(%rax), %cl
	movq	-8(%rbp), %rax
	movb	%cl, (%rax)
	movq	-8(%rbp), %rax
	addq	$1, %rax
	movq	%rax, -8(%rbp)
	movq	-16(%rbp), %rax
	addq	$1, %rax
	movq	%rax, -16(%rbp)
	jmp	LBB2_1
LBB2_4:
	movq	-8(%rbp), %rax
	movb	$0, (%rax)
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_count_odds             ## -- Begin function count_odds
	.p2align	4, 0x90
_count_odds:                            ## @count_odds
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movl	%esi, -12(%rbp)
	movl	$0, -16(%rbp)
	movl	$0, -20(%rbp)
	movq	-8(%rbp), %rdi
	movl	(%rdi), %esi
	andl	$1, %esi
	cmpl	$1, %esi
	jne	LBB3_2
## %bb.1:
	jmp	LBB3_8
LBB3_2:
	jmp	LBB3_3
LBB3_3:                                 ## =>This Inner Loop Header: Depth=1
	movl	-20(%rbp), %eax
	cmpl	-12(%rbp), %eax
	jl	LBB3_5
## %bb.4:
	jmp	LBB3_9
LBB3_5:                                 ##   in Loop: Header=BB3_3 Depth=1
	movl	-20(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -20(%rbp)
	movq	-8(%rbp), %rcx
	addq	$4, %rcx
	movq	%rcx, -8(%rbp)
	movq	-8(%rbp), %rcx
	movl	(%rcx), %eax
	andl	$1, %eax
	cmpl	$1, %eax
	jne	LBB3_7
## %bb.6:
	jmp	LBB3_8
LBB3_7:                                 ##   in Loop: Header=BB3_3 Depth=1
	jmp	LBB3_3
LBB3_8:
	movl	-16(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -16(%rbp)
	jmp	LBB3_3
LBB3_9:
	movl	-16(%rbp), %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_power                  ## -- Begin function power
	.p2align	4, 0x90
_power:                                 ## @power
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	%edi, -4(%rbp)
	movl	%esi, -8(%rbp)
	movl	$1, -12(%rbp)
	movl	$0, -16(%rbp)
LBB4_1:                                 ## =>This Inner Loop Header: Depth=1
	movl	-16(%rbp), %eax
	cmpl	-8(%rbp), %eax
	jl	LBB4_3
## %bb.2:
	jmp	LBB4_4
LBB4_3:                                 ##   in Loop: Header=BB4_1 Depth=1
	movl	-12(%rbp), %eax
	imull	-4(%rbp), %eax
	movl	%eax, -12(%rbp)
	movl	-16(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -16(%rbp)
	jmp	LBB4_1
LBB4_4:
	movl	-12(%rbp), %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_main                   ## -- Begin function main
	.p2align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$144, %rsp
	leaq	-32(%rbp), %rdi
	movq	___stack_chk_guard@GOTPCREL(%rip), %rax
	movq	(%rax), %rax
	movq	%rax, -8(%rbp)
	movl	$0, -100(%rbp)
	movq	l___const.main.arr(%rip), %rax
	movq	%rax, -32(%rbp)
	movq	l___const.main.arr+8(%rip), %rax
	movq	%rax, -24(%rbp)
	movl	l___const.main.arr+16(%rip), %ecx
	movl	%ecx, -16(%rbp)
	movl	$5, %esi
	callq	_reverse
	leaq	L_.str(%rip), %rdi
	movb	$0, %al
	callq	_printf
	movl	$0, -104(%rbp)
	movl	%eax, -108(%rbp)        ## 4-byte Spill
LBB5_1:                                 ## =>This Inner Loop Header: Depth=1
	cmpl	$5, -104(%rbp)
	jge	LBB5_4
## %bb.2:                               ##   in Loop: Header=BB5_1 Depth=1
	movslq	-104(%rbp), %rax
	movl	-32(%rbp,%rax,4), %esi
	leaq	L_.str.1(%rip), %rdi
	movb	$0, %al
	callq	_printf
	movl	%eax, -112(%rbp)        ## 4-byte Spill
## %bb.3:                               ##   in Loop: Header=BB5_1 Depth=1
	movl	-104(%rbp), %eax
	addl	$1, %eax
	movl	%eax, -104(%rbp)
	jmp	LBB5_1
LBB5_4:
	leaq	L_.str.2(%rip), %rdi
	movb	$0, %al
	callq	_printf
	leaq	-32(%rbp), %rdi
	movl	$5, %esi
	movl	%eax, -116(%rbp)        ## 4-byte Spill
	callq	_max
	leaq	L_.str.3(%rip), %rdi
	movl	%eax, %esi
	movb	$0, %al
	callq	_printf
	leaq	-40(%rbp), %rsi
	leaq	-96(%rbp), %rdi
	movq	L___const.main.course(%rip), %rcx
	movq	%rcx, -40(%rbp)
	movl	%eax, -120(%rbp)        ## 4-byte Spill
	callq	_strcpy373
	leaq	-96(%rbp), %rsi
	leaq	L_.str.4(%rip), %rdi
	movb	$0, %al
	callq	_printf
	leaq	-32(%rbp), %rdi
	movl	$5, %esi
	movl	%eax, -124(%rbp)        ## 4-byte Spill
	callq	_count_odds
	leaq	L_.str.5(%rip), %rdi
	movl	%eax, %esi
	movb	$0, %al
	callq	_printf
	movl	$3, %edi
	movl	$4, %esi
	movl	%eax, -128(%rbp)        ## 4-byte Spill
	callq	_power
	leaq	L_.str.6(%rip), %rdi
	movl	$3, %esi
	movl	$4, %edx
	movl	%eax, %ecx
	movb	$0, %al
	callq	_printf
	movl	-100(%rbp), %ecx
	movq	___stack_chk_guard@GOTPCREL(%rip), %rdi
	movq	(%rdi), %rdi
	movq	-8(%rbp), %r8
	cmpq	%r8, %rdi
	movl	%eax, -132(%rbp)        ## 4-byte Spill
	movl	%ecx, -136(%rbp)        ## 4-byte Spill
	jne	LBB5_6
## %bb.5:
	movl	-136(%rbp), %eax        ## 4-byte Reload
	addq	$144, %rsp
	popq	%rbp
	retq
LBB5_6:
	callq	___stack_chk_fail
	ud2
	.cfi_endproc
                                        ## -- End function
	.section	__TEXT,__const
	.p2align	4               ## @__const.main.arr
l___const.main.arr:
	.long	1                       ## 0x1
	.long	2                       ## 0x2
	.long	5                       ## 0x5
	.long	4                       ## 0x4
	.long	3                       ## 0x3

	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	"Reverse is "

L_.str.1:                               ## @.str.1
	.asciz	"%d "

L_.str.2:                               ## @.str.2
	.asciz	"\n"

L_.str.3:                               ## @.str.3
	.asciz	"Max is %d\n"

L___const.main.course:                  ## @__const.main.course
	.asciz	"csc 373"

L_.str.4:                               ## @.str.4
	.asciz	"Copy is %s\n"

L_.str.5:                               ## @.str.5
	.asciz	"# of odds is %d\n"

L_.str.6:                               ## @.str.6
	.asciz	"%d to the power of %d is %d\n"


.subsections_via_symbols
