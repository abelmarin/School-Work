.data
.text
.global main
main:
	cmpl    $1, %edi
    je      .L3
    xorl    %eax, %eax
    testl   %edi, %edi
    jle     .L7
    subq    $8, %rsp
    subl    $1, %edi
    call    main
    testl   %eax, %eax
    sete    %al
    addq    $8, %rsp
    movzbl  %al, %eax
.L7:
    ret
.L3:
    movl    $1, %eax
    ret 
