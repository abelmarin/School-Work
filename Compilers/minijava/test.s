.data
_BS$:
        .quad 0
        .quad _BS$Start
        .quad _BS$Search
        .quad _BS$Div
        .quad _BS$Compare
        .quad _BS$Print
        .quad _BS$Init

.text
.globl _asm_main

_asm_main:
        pushq   %rbp
        movq    %rsp, %rbp
        movq    $32, %rdi
        call    _mjcalloc
        movabs  $_BS$, %rdx
        movq    %rdx, 0(%rax)
        pushq   %rax
        movq    $20, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *8(%rax)
        movq    %rax, %rdi
        call    _put
        leave
        ret
_BS$Start:
        pushq   %rbp
        movq    %rsp, %rbp
        subq    $32, %rsp
        movq    %rdi, -8(%rbp)
        movq    %rsi, -16(%rbp)
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    -16(%rbp), %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *48(%rax)
        pushq   %rax
        popq    %r10
        movq    %r10, -24(%rbp)
        movq    -8(%rbp), %rax
        pushq   %rax
        popq    %rdi
        movq    0(%rdi), %rax
        call    *40(%rax)
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    $8, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *16(%rax)
        cmp     $0, %rax
        je      _L0
        movq    $1, %rax
        movq    %rax, %rdi
        call    _put
        jmp     _L1
_L0:
        movq    $0, %rax
        movq    %rax, %rdi
        call    _put
_L1:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    $19, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *16(%rax)
        cmp     $0, %rax
        je      _L2
        movq    $1, %rax
        movq    %rax, %rdi
        call    _put
        jmp     _L3
_L2:
        movq    $0, %rax
        movq    %rax, %rdi
        call    _put
_L3:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    $20, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *16(%rax)
        cmp     $0, %rax
        je      _L4
        movq    $1, %rax
        movq    %rax, %rdi
        call    _put
        jmp     _L5
_L4:
        movq    $0, %rax
        movq    %rax, %rdi
        call    _put
_L5:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    $21, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *16(%rax)
        cmp     $0, %rax
        je      _L6
        movq    $1, %rax
        movq    %rax, %rdi
        call    _put
        jmp     _L7
_L6:
        movq    $0, %rax
        movq    %rax, %rdi
        call    _put
_L7:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    $37, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *16(%rax)
        cmp     $0, %rax
        je      _L8
        movq    $1, %rax
        movq    %rax, %rdi
        call    _put
        jmp     _L9
_L8:
        movq    $0, %rax
        movq    %rax, %rdi
        call    _put
_L9:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    $38, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *16(%rax)
        cmp     $0, %rax
        je      _L10
        movq    $1, %rax
        movq    %rax, %rdi
        call    _put
        jmp     _L11
_L10:
        movq    $0, %rax
        movq    %rax, %rdi
        call    _put
_L11:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    $39, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *16(%rax)
        cmp     $0, %rax
        je      _L12
        movq    $1, %rax
        movq    %rax, %rdi
        call    _put
        jmp     _L13
_L12:
        movq    $0, %rax
        movq    %rax, %rdi
        call    _put
_L13:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    $50, %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *16(%rax)
        cmp     $0, %rax
        je      _L14
        movq    $1, %rax
        movq    %rax, %rdi
        call    _put
        jmp     _L15
_L14:
        movq    $0, %rax
        movq    %rax, %rdi
        call    _put
_L15:
        movq    $999, %rax
        leave
        ret
_BS$Search:
        pushq   %rbp
        movq    %rsp, %rbp
        subq    $80, %rsp
        movq    %rdi, -8(%rbp)
        movq    %rsi, -16(%rbp)
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -64(%rbp)
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -24(%rbp)
        movq    -8(%rbp), %rax
        movq    -8(%rax), %rax
        movq    0(%rax), %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        movq    $1, %rax
        pushq   %rax
        movq    -32(%rbp), %rax
        popq    %r10
        subq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -40(%rbp)
        movq    $1, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -48(%rbp)
_L16:
        movq    -48(%rbp), %rax
        cmp     $0, %rax
        je      _L17
        movq    -40(%rbp), %rax
        pushq   %rax
        movq    -32(%rbp), %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -56(%rbp)
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    -56(%rbp), %rax
        pushq   %rax
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *24(%rax)
        pushq   %rax
        popq    %r10
        movq    %r10, -56(%rbp)
        movq    -8(%rbp), %rax
        movq    -8(%rax), %rax
        pushq   %rax
        movq    -56(%rbp), %rax
        popq    %r10
        movq    16(%r10,%rax,8), %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -64(%rbp)
        movq    -16(%rbp), %rax
        pushq   %rax
        movq    -64(%rbp), %rax
        popq    %r10
        cmpq    %r10, %rax
        setg    %al
        movzbq  %al, %rax
        cmp     $0, %rax
        je      _L18
        movq    $1, %rax
        pushq   %rax
        movq    -56(%rbp), %rax
        popq    %r10
        subq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        jmp     _L19
_L18:
        movq    -56(%rbp), %rax
        pushq   %rax
        movq    $1, %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -40(%rbp)
_L19:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    -64(%rbp), %rax
        pushq   %rax
        movq    -16(%rbp), %rax
        pushq   %rax
        popq    %rdx
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *32(%rax)
        cmp     $0, %rax
        je      _L20
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -48(%rbp)
        jmp     _L21
_L20:
        movq    $1, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -48(%rbp)
_L21:
        movq    -32(%rbp), %rax
        pushq   %rax
        movq    -40(%rbp), %rax
        popq    %r10
        cmpq    %r10, %rax
        setg    %al
        movzbq  %al, %rax
        cmp     $0, %rax
        je      _L22
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -48(%rbp)
        jmp     _L23
_L22:
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -72(%rbp)
_L23:
        jmp     _L16
_L17:
        movq    -8(%rbp), %rax
        pushq   %rax
        movq    -64(%rbp), %rax
        pushq   %rax
        movq    -16(%rbp), %rax
        pushq   %rax
        popq    %rdx
        popq    %rsi
        popq    %rdi
        movq    0(%rdi), %rax
        call    *32(%rax)
        cmp     $0, %rax
        je      _L24
        movq    $1, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -24(%rbp)
        jmp     _L25
_L24:
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -24(%rbp)
_L25:
        movq    -24(%rbp), %rax
        leave
        ret
_BS$Div:
        pushq   %rbp
        movq    %rsp, %rbp
        subq    $48, %rsp
        movq    %rdi, -8(%rbp)
        movq    %rsi, -16(%rbp)
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -24(%rbp)
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        movq    $1, %rax
        pushq   %rax
        movq    -16(%rbp), %rax
        popq    %r10
        subq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -40(%rbp)
_L26:
        movq    -32(%rbp), %rax
        pushq   %rax
        movq    -40(%rbp), %rax
        popq    %r10
        cmpq    %r10, %rax
        setg    %al
        movzbq  %al, %rax
        cmp     $0, %rax
        je      _L27
        movq    -24(%rbp), %rax
        pushq   %rax
        movq    $1, %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -24(%rbp)
        movq    -32(%rbp), %rax
        pushq   %rax
        movq    $2, %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        jmp     _L26
_L27:
        movq    -24(%rbp), %rax
        leave
        ret
_BS$Compare:
        pushq   %rbp
        movq    %rsp, %rbp
        subq    $48, %rsp
        movq    %rdi, -8(%rbp)
        movq    %rsi, -16(%rbp)
        movq    %rdx, -24(%rbp)
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        movq    -24(%rbp), %rax
        pushq   %rax
        movq    $1, %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -40(%rbp)
        movq    -16(%rbp), %rax
        pushq   %rax
        movq    -24(%rbp), %rax
        popq    %r10
        cmpq    %r10, %rax
        setg    %al
        movzbq  %al, %rax
        cmp     $0, %rax
        je      _L28
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        jmp     _L29
_L28:
        movq    -16(%rbp), %rax
        pushq   %rax
        movq    -40(%rbp), %rax
        popq    %r10
        cmpq    %r10, %rax
        setg    %al
        movzbq  %al, %rax
        cmpq    $0, %rax
        sete    %al
        movzbq  %al, %rax
        cmp     $0, %rax
        je      _L30
        movq    $0, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        jmp     _L31
_L30:
        movq    $1, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
_L31:
_L29:
        movq    -32(%rbp), %rax
        leave
        ret
_BS$Print:
        pushq   %rbp
        movq    %rsp, %rbp
        subq    $16, %rsp
        movq    %rdi, -8(%rbp)
        movq    $1, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -16(%rbp)
_L32:
        movq    -16(%rbp), %rax
        pushq   %rax
        movq    -8(%rbp), %rax
        movq    -16(%rax), %rax
        popq    %r10
        cmpq    %r10, %rax
        setg    %al
        movzbq  %al, %rax
        cmp     $0, %rax
        je      _L33
        movq    -8(%rbp), %rax
        movq    -8(%rax), %rax
        pushq   %rax
        movq    -16(%rbp), %rax
        popq    %r10
        movq    16(%r10,%rax,8), %rax
        movq    %rax, %rdi
        call    _put
        movq    -16(%rbp), %rax
        pushq   %rax
        movq    $1, %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -16(%rbp)
        jmp     _L32
_L33:
        movq    $99999, %rax
        movq    %rax, %rdi
        call    _put
        movq    $0, %rax
        leave
        ret
_BS$Init:
        pushq   %rbp
        movq    %rsp, %rbp
        subq    $48, %rsp
        movq    %rdi, -8(%rbp)
        movq    %rsi, -16(%rbp)
        movq    -16(%rbp), %rax
        pushq   %rax
        movq    -8(%rbp), %rax
        popq    %r10
        movq    %r10, -16(%rax)
        movq    -16(%rbp), %rax
        pushq   %rax
        imulq   $8, %rax
        addq    $16, %rax
        movq    %rax, %rdi
        call    _mjcalloc
        popq    0(%rax)
        movq    $16, 8(%rax)
        pushq   %rax
        movq    -8(%rbp), %rax
        popq    %r10
        movq    %r10, -8(%rax)
        movq    $1, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -24(%rbp)
        movq    -8(%rbp), %rax
        movq    -16(%rax), %rax
        pushq   %rax
        movq    $1, %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
_L34:
        movq    -24(%rbp), %rax
        pushq   %rax
        movq    -8(%rbp), %rax
        movq    -16(%rax), %rax
        popq    %r10
        cmpq    %r10, %rax
        setg    %al
        movzbq  %al, %rax
        cmp     $0, %rax
        je      _L35
        movq    $2, %rax
        pushq   %rax
        movq    -24(%rbp), %rax
        popq    %r10
        imulq   %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -48(%rbp)
        movq    $3, %rax
        pushq   %rax
        movq    -32(%rbp), %rax
        popq    %r10
        subq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -40(%rbp)
        movq    -48(%rbp), %rax
        pushq   %rax
        movq    -40(%rbp), %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        movq    -8(%rbp), %rax
        pushq   -8(%rax)
        movq    -24(%rbp), %rax
        popq    %r10
        popq    %rdx
        movq    %rdx, 16(%r10,%rax,8)
        movq    -24(%rbp), %rax
        pushq   %rax
        movq    $1, %rax
        popq    %r10
        addq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -24(%rbp)
        movq    $1, %rax
        pushq   %rax
        movq    -32(%rbp), %rax
        popq    %r10
        subq    %r10, %rax
        pushq   %rax
        popq    %r10
        movq    %r10, -32(%rbp)
        jmp     _L34
_L35:
        movq    $0, %rax
        leave
        ret
