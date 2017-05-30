	default rel

	global hex2int
	global int2chr
	global toStringHex
	global rotate_left
	global add
	global lohi
	global sha1
	global computeSHA1
	global nextLetter
	global nextText
	global array_equal
	global crackSHA1
	global main

extern printf, malloc, strcpy, scanf, strlen, sscanf, sprintf, memcpy, strcmp, puts

	SECTION .text

hex2int:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 336
	mov		qword[rsp-96], r12
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	sub		rsp, 128
hex2int_0_beginning:
	jmp		hex2int_1_entry

hex2int_1_entry:
	mov		r15, 0

	mov		r13, 0

	jmp		hex2int_2_forCondition

hex2int_2_forCondition:
	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	call	FBH_string_length
	add		rsp, 128
	mov		r12, rax

	cmp		r13, r12
	setl		al
	movzx	r14, al

	test	r14, r14
	jz		hex2int_23_forMerge
	jmp		hex2int_3_forBody

hex2int_3_forBody:
	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	mov		rsi, r13
	call	FBH_string_ord
	add		rsp, 128
	mov		r12, rax

	mov		r14, r12

	mov		rax, 48
	cmp		r14, rax
	setge		al
	movzx	r12, al

	test	r12, r12
	jz		hex2int_5_leftFalse
	jmp		hex2int_4_leftTrue

hex2int_4_leftTrue:
	mov		rax, 57
	cmp		r14, rax
	setle		al
	movzx	r12, al

	jmp		hex2int_6_mergeBranch

hex2int_5_leftFalse:
	mov		r12, 0

	jmp		hex2int_6_mergeBranch

hex2int_6_mergeBranch:
	test	r12, r12
	jz		hex2int_8_ifFalse
	jmp		hex2int_7_ifTrue

hex2int_7_ifTrue:
	mov		rcx, 16
	mov		r12, r15
	imul		r12, rcx

	add		r12, r14

	mov		rcx, 48
	sub		r12, rcx

	mov		r15, r12

	jmp		hex2int_21_ifMerge

hex2int_8_ifFalse:
	mov		rax, 65
	cmp		r14, rax
	setge		al
	movzx	r12, al

	test	r12, r12
	jz		hex2int_10_leftFalse
	jmp		hex2int_9_leftTrue

hex2int_9_leftTrue:
	mov		rax, 70
	cmp		r14, rax
	setle		al
	movzx	r12, al

	jmp		hex2int_11_mergeBranch

hex2int_10_leftFalse:
	mov		r12, 0

	jmp		hex2int_11_mergeBranch

hex2int_11_mergeBranch:
	test	r12, r12
	jz		hex2int_13_ifFalse
	jmp		hex2int_12_ifTrue

hex2int_12_ifTrue:
	mov		rcx, 16
	mov		r12, r15
	imul		r12, rcx

	add		r12, r14

	mov		rcx, 65
	sub		r12, rcx

	mov		rcx, 10
	add		r12, rcx

	mov		r15, r12

	jmp		hex2int_20_ifMerge

hex2int_13_ifFalse:
	mov		rax, 97
	cmp		r14, rax
	setge		al
	movzx	r12, al

	test	r12, r12
	jz		hex2int_15_leftFalse
	jmp		hex2int_14_leftTrue

hex2int_14_leftTrue:
	mov		rax, 102
	cmp		r14, rax
	setle		al
	movzx	r12, al

	jmp		hex2int_16_mergeBranch

hex2int_15_leftFalse:
	mov		r12, 0

	jmp		hex2int_16_mergeBranch

hex2int_16_mergeBranch:
	test	r12, r12
	jz		hex2int_18_ifFalse
	jmp		hex2int_17_ifTrue

hex2int_17_ifTrue:
	mov		rcx, 16
	mov		r12, r15
	imul		r12, rcx

	add		r12, r14

	mov		rcx, 97
	sub		r12, rcx

	mov		rcx, 10
	add		r12, rcx

	mov		r15, r12

	jmp		hex2int_19_ifMerge

hex2int_18_ifFalse:
	mov		rax, 0
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		hex2int_24_exit

hex2int_19_ifMerge:
	jmp		hex2int_20_ifMerge

hex2int_20_ifMerge:
	jmp		hex2int_21_ifMerge

hex2int_21_ifMerge:
	jmp		hex2int_22_forIncrease

hex2int_22_forIncrease:
	mov		r12, r13

	mov		rcx, 1
	add		r13, rcx

	jmp		hex2int_2_forCondition

hex2int_23_forMerge:
	mov		rax, r15
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		hex2int_24_exit

hex2int_24_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret


int2chr:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 176
	mov		qword[rsp-96], r12
	mov		qword[rsp-104], r13
	sub		rsp, 128
int2chr_0_beginning:
	jmp		int2chr_1_entry

int2chr_1_entry:
	mov		rdx, qword [rbp+16]
	mov		rax, 32
	cmp		rdx, rax
	setge		al
	movzx	r12, al

	test	r12, r12
	jz		int2chr_3_leftFalse
	jmp		int2chr_2_leftTrue

int2chr_2_leftTrue:
	mov		rdx, qword [rbp+16]
	mov		rax, 126
	cmp		rdx, rax
	setle		al
	movzx	r12, al

	jmp		int2chr_4_mergeBranch

int2chr_3_leftFalse:
	mov		r12, 0

	jmp		int2chr_4_mergeBranch

int2chr_4_mergeBranch:
	test	r12, r12
	jz		int2chr_6_ifFalse
	jmp		int2chr_5_ifTrue

int2chr_5_ifTrue:
	mov		rax, qword [rbp+16]
	mov		rcx, 32
	mov		r13, rax
	sub		r13, rcx

	mov		rax, qword [rbp+16]
	mov		rcx, 32
	mov		r12, rax
	sub		r12, rcx

	sub		rsp, 128
	mov		rdi, qword [global_var_asciiTable]
	mov		rsi, r13
	mov		rdx, r12
	call	FBH_string_substring
	add		rsp, 128
	mov		r12, rax

	mov		rax, r12
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	leave
	ret

	jmp		int2chr_8_exit

int2chr_6_ifFalse:
	jmp		int2chr_7_ifMerge

int2chr_7_ifMerge:
	mov		rax, ___message___85
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	leave
	ret

	jmp		int2chr_8_exit

int2chr_8_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	leave
	ret


toStringHex:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 256
	mov		qword[rsp-96], r12
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	sub		rsp, 128
toStringHex_0_beginning:
	jmp		toStringHex_1_entry

toStringHex_1_entry:
	mov		rax, ___message___86
	mov		r15, rax

	mov		r13, 28

	jmp		toStringHex_2_forCondition

toStringHex_2_forCondition:
	mov		rax, 0
	cmp		r13, rax
	setge		al
	movzx	r12, al

	test	r12, r12
	jz		toStringHex_8_forMerge
	jmp		toStringHex_3_forBody

toStringHex_3_forBody:
	mov		rax, qword [rbp+16]
	mov		rcx, r13
	sar		rax, cl
	mov		r12, rax

	mov		rcx, 15
	and		r12, rcx


	mov		rax, 10
	cmp		r12, rax
	setl		al
	movzx	r14, al

	test	r14, r14
	jz		toStringHex_5_ifFalse
	jmp		toStringHex_4_ifTrue

toStringHex_4_ifTrue:
	mov		rax, 48
	mov		r14, rax
	add		r14, r12

	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+0], r14
	call	int2chr
	add		rsp, 16
	add		rsp, 128
	mov		r12, rax

	sub		rsp, 128
	mov		rdi, r15
	mov		rsi, r12
	call	FBH_string_connect
	add		rsp, 128
	mov		r12, rax

	mov		r15, r12

	jmp		toStringHex_6_ifMerge

toStringHex_5_ifFalse:
	mov		rax, 65
	mov		r14, rax
	add		r14, r12

	mov		rcx, 10
	mov		r12, r14
	sub		r12, rcx

	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+0], r12
	call	int2chr
	add		rsp, 16
	add		rsp, 128
	mov		r12, rax

	sub		rsp, 128
	mov		rdi, r15
	mov		rsi, r12
	call	FBH_string_connect
	add		rsp, 128
	mov		r12, rax

	mov		r15, r12

	jmp		toStringHex_6_ifMerge

toStringHex_6_ifMerge:
	jmp		toStringHex_7_forIncrease

toStringHex_7_forIncrease:
	mov		rcx, 4
	mov		r12, r13
	sub		r12, rcx

	mov		r13, r12

	jmp		toStringHex_2_forCondition

toStringHex_8_forMerge:
	mov		rax, r15
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		toStringHex_9_exit

toStringHex_9_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret


rotate_left:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 336
	mov		qword[rsp-96], r12
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	sub		rsp, 128
rotate_left_0_beginning:
	jmp		rotate_left_1_entry

rotate_left_1_entry:
	mov		rdx, qword [rbp+24]
	mov		rax, 1
	cmp		rdx, rax
	sete		al
	movzx	r12, al

	test	r12, r12
	jz		rotate_left_3_ifFalse
	jmp		rotate_left_2_ifTrue

rotate_left_2_ifTrue:
	mov		rax, qword [rbp+16]
	mov		rcx, 2147483647
	mov		r12, rax
	and		r12, rcx

	mov		rcx, 1
	mov		rax, r12
	sal		rax, cl
	mov		r13, rax

	mov		rax, qword [rbp+16]
	mov		rcx, 31
	sar		rax, cl
	mov		r12, rax

	mov		rcx, 1
	and		r12, rcx

	or		r13, r12

	mov		rax, r13
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		rotate_left_8_exit

rotate_left_3_ifFalse:
	jmp		rotate_left_4_ifMerge

rotate_left_4_ifMerge:
	mov		rdx, qword [rbp+24]
	mov		rax, 31
	cmp		rdx, rax
	sete		al
	movzx	r12, al

	test	r12, r12
	jz		rotate_left_6_ifFalse
	jmp		rotate_left_5_ifTrue

rotate_left_5_ifTrue:
	mov		rax, qword [rbp+16]
	mov		rcx, 1
	mov		r12, rax
	and		r12, rcx

	mov		rcx, 31
	mov		rax, r12
	sal		rax, cl
	mov		r13, rax

	mov		rax, qword [rbp+16]
	mov		rcx, 1
	sar		rax, cl
	mov		r12, rax

	mov		rcx, 2147483647
	and		r12, rcx

	or		r13, r12

	mov		rax, r13
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		rotate_left_8_exit

rotate_left_6_ifFalse:
	jmp		rotate_left_7_ifMerge

rotate_left_7_ifMerge:
	mov		rax, 32
	mov		rcx, qword [rbp+24]
	mov		r13, rax
	sub		r13, rcx

	mov		rax, 1
	mov		rcx, r13
	sal		rax, cl
	mov		r12, rax

	mov		rcx, 1
	sub		r12, rcx

	mov		rax, qword [rbp+16]
	mov		r13, rax
	and		r13, r12

	mov		rcx, qword [rbp+24]
	mov		rax, r13
	sal		rax, cl
	mov		r13, rax

	mov		rax, 32
	mov		rcx, qword [rbp+24]
	mov		r14, rax
	sub		r14, rcx

	mov		rax, qword [rbp+16]
	mov		rcx, r14
	sar		rax, cl
	mov		r12, rax

	mov		rax, 1
	mov		rcx, qword [rbp+24]
	sal		rax, cl
	mov		r14, rax

	mov		rcx, 1
	sub		r14, rcx

	and		r12, r14

	or		r13, r12

	mov		rax, r13
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		rotate_left_8_exit

rotate_left_8_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret


add:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 272
	mov		qword[rsp-96], r12
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	sub		rsp, 128
add_0_beginning:
	jmp		add_1_entry

add_1_entry:
	mov		rax, qword [rbp+16]
	mov		rcx, 65535
	mov		r12, rax
	and		r12, rcx

	mov		rax, qword [rbp+24]
	mov		rcx, 65535
	mov		r13, rax
	and		r13, rcx

	add		r12, r13

	mov		r13, r12

	mov		rax, qword [rbp+16]
	mov		rcx, 16
	sar		rax, cl
	mov		r12, rax

	mov		rcx, 65535
	and		r12, rcx

	mov		rax, qword [rbp+24]
	mov		rcx, 16
	sar		rax, cl
	mov		r14, rax

	mov		rcx, 65535
	and		r14, rcx

	add		r12, r14

	mov		rcx, 16
	mov		rax, r13
	sar		rax, cl
	mov		r14, rax

	add		r12, r14

	mov		rcx, 65535
	and		r12, rcx


	mov		rcx, 16
	mov		rax, r12
	sal		rax, cl
	mov		r12, rax

	mov		rcx, 65535
	and		r13, rcx

	or		r12, r13

	mov		rax, r12
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		add_2_exit

add_2_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret


lohi:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 160
	mov		qword[rsp-96], r12
	mov		qword[rsp-104], r13
	sub		rsp, 128
lohi_0_beginning:
	jmp		lohi_1_entry

lohi_1_entry:
	mov		rax, qword [rbp+24]
	mov		rcx, 16
	sal		rax, cl
	mov		r13, rax

	mov		rax, qword [rbp+16]
	mov		r12, rax
	or		r12, r13

	mov		rax, r12
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	leave
	ret

	jmp		lohi_2_exit

lohi_2_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r13, qword[rsp-104]
	leave
	ret


sha1:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 1712
	mov		qword[rsp-96], r12
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-24], rbx
	mov		qword[rsp-112], r14
	sub		rsp, 128
sha1_0_beginning:
	jmp		sha1_1_entry

sha1_1_entry:
	mov		rax, qword [rbp+24]
	mov		rcx, 64
	mov		r12, rax
	add		r12, rcx

	mov		rcx, 56
	sub		r12, rcx

	mov		rax, r12
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		r12, rax

	mov		rcx, 1
	add		r12, rcx

	mov		r14, r12

	mov		rax, qword [global_var_MAXCHUNK]
	cmp		r14, rax
	setg		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_3_ifFalse
	jmp		sha1_2_ifTrue

sha1_2_ifTrue:
	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	mov		rdi, ___message___143
	call	FBH_println
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]

	mov		rax, 0
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		rbx, qword[rsp-24]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		sha1_38_exit

sha1_3_ifFalse:
	jmp		sha1_4_ifMerge

sha1_4_ifMerge:
	mov		r15, 0

	jmp		sha1_5_forCondition

sha1_5_forCondition:
	cmp		r15, r14
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_12_forMerge
	jmp		sha1_6_forBody

sha1_6_forBody:
	mov		rax, qword [rbp-656]
	mov		rax, 0
	mov		qword [rbp-656], rax

	jmp		sha1_7_forCondition

sha1_7_forCondition:
	mov		rdx, qword [rbp-656]
	mov		rax, 80
	cmp		rdx, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_10_forMerge
	jmp		sha1_8_forBody

sha1_8_forBody:
	mov		rcx, 8
	mov		r13, r15
	imul		r13, rcx

	mov		rax, qword [global_var_chunks]
	mov		r12, rax
	add		r12, r13

	mov		r12, [r12 + 0*8]

	mov		rax, qword [rbp-656]
	mov		rcx, 8
	mov		r13, rax
	imul		r13, rcx

	add		r12, r13

	mov		rdx, 0
	mov		[r12 + 0 * 8], rdx

	mov		r12, [r12 + 0*8]

	jmp		sha1_9_forIncrease

sha1_9_forIncrease:
	mov		rax, qword [rbp-656]
	mov		r12, rax

	mov		rax, qword [rbp-656]
	mov		rcx, 1
	mov		rdx, qword [rbp-656]
	mov		rdx, rax
	add		rdx, rcx
	mov		qword [rbp-656], rdx

	jmp		sha1_7_forCondition

sha1_10_forMerge:
	jmp		sha1_11_forIncrease

sha1_11_forIncrease:
	mov		r12, r15

	mov		rcx, 1
	add		r15, rcx

	jmp		sha1_5_forCondition

sha1_12_forMerge:
	mov		r15, 0

	jmp		sha1_13_forCondition

sha1_13_forCondition:
	mov		rax, qword [rbp+24]
	cmp		r15, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_16_forMerge
	jmp		sha1_14_forBody

sha1_14_forBody:
	mov		rax, r15
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		r12, rax

	mov		rcx, 8
	imul		r12, rcx

	mov		rax, qword [global_var_chunks]
	mov		r13, rax
	add		r13, r12

	mov		r13, [r13 + 0*8]

	mov		rax, r15
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		r12, rdx

	mov		rax, r12
	mov		rcx, 4
	cqo
	idiv	rcx
	mov		r12, rax

	mov		rcx, 8
	imul		r12, rcx

	mov		r9, r13
	add		r9, r12

	mov		rax, r15
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		r12, rax

	mov		rcx, 8
	mov		r13, r12
	imul		r13, rcx

	mov		rax, qword [global_var_chunks]
	mov		r12, rax
	add		r12, r13

	mov		r13, [r12 + 0*8]

	mov		rax, r15
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		r12, rdx

	mov		rax, r12
	mov		rcx, 4
	cqo
	idiv	rcx
	mov		r12, rax

	mov		rcx, 8
	imul		r12, rcx

	add		r13, r12

	mov		rbx, [r13 + 0*8]

	mov		rcx, 8
	mov		r13, r15
	imul		r13, rcx

	mov		rax, qword [rbp+16]
	mov		r12, rax
	add		r12, r13

	mov		r8, [r12 + 0*8]

	mov		rax, r15
	mov		rcx, 4
	cqo
	idiv	rcx
	mov		r12, rdx

	mov		rax, 3
	mov		r13, rax
	sub		r13, r12

	mov		rcx, 8
	mov		r12, r13
	imul		r12, rcx

	mov		rax, r8
	mov		rcx, r12
	sal		rax, cl
	mov		r13, rax

	mov		r12, rbx
	or		r12, r13

	mov		[r9 + 0 * 8], r12

	mov		r12, [r9 + 0*8]

	jmp		sha1_15_forIncrease

sha1_15_forIncrease:
	mov		r12, r15

	mov		rcx, 1
	add		r15, rcx

	jmp		sha1_13_forCondition

sha1_16_forMerge:
	mov		rax, r15
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		r12, rax

	mov		rcx, 8
	imul		r12, rcx

	mov		rax, qword [global_var_chunks]
	mov		r13, rax
	add		r13, r12

	mov		r12, [r13 + 0*8]

	mov		rax, r15
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		r13, rdx

	mov		rax, r13
	mov		rcx, 4
	cqo
	idiv	rcx
	mov		r13, rax

	mov		rcx, 8
	imul		r13, rcx

	add		r12, r13

	mov		rax, r15
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		r13, rax

	mov		rcx, 8
	imul		r13, rcx

	mov		rax, qword [global_var_chunks]
	mov		rbx, rax
	add		rbx, r13

	mov		r13, [rbx + 0*8]

	mov		rax, r15
	mov		rcx, 64
	cqo
	idiv	rcx
	mov		rbx, rdx

	mov		rax, rbx
	mov		rcx, 4
	cqo
	idiv	rcx
	mov		rbx, rax

	mov		rcx, 8
	imul		rbx, rcx

	add		r13, rbx

	mov		r13, [r13 + 0*8]

	mov		rax, r15
	mov		rcx, 4
	cqo
	idiv	rcx
	mov		r15, rdx

	mov		rax, 3
	mov		rbx, rax
	sub		rbx, r15

	mov		rcx, 8
	imul		rbx, rcx

	mov		rax, 128
	mov		rcx, rbx
	sal		rax, cl
	mov		r15, rax

	or		r13, r15

	mov		[r12 + 0 * 8], r13

	mov		r12, [r12 + 0*8]

	mov		rcx, 1
	mov		r12, r14
	sub		r12, rcx

	mov		rcx, 8
	imul		r12, rcx

	mov		rax, qword [global_var_chunks]
	mov		r13, rax
	add		r13, r12

	mov		r12, [r13 + 0*8]

	mov		rax, 15
	mov		rcx, 8
	mov		r13, rax
	imul		r13, rcx

	add		r12, r13

	mov		rax, qword [rbp+24]
	mov		rcx, 3
	sal		rax, cl
	mov		r13, rax

	mov		[r12 + 0 * 8], r13

	mov		r12, [r12 + 0*8]

	mov		rcx, 1
	mov		r12, r14
	sub		r12, rcx

	mov		rcx, 8
	imul		r12, rcx

	mov		rax, qword [global_var_chunks]
	mov		r13, rax
	add		r13, r12

	mov		r12, [r13 + 0*8]

	mov		rax, 14
	mov		rcx, 8
	mov		r13, rax
	imul		r13, rcx

	add		r12, r13

	mov		rax, qword [rbp+24]
	mov		rcx, 29
	sar		rax, cl
	mov		r13, rax

	mov		rcx, 7
	and		r13, rcx

	mov		[r12 + 0 * 8], r13

	mov		r12, [r12 + 0*8]

	mov		r9, 1732584193

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, 61389
	mov		qword[rsp+8], rax
	mov		rax, 43913
	mov		qword[rsp+0], rax
	call	lohi
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		r11, r12

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, 39098
	mov		qword[rsp+8], rax
	mov		rax, 56574
	mov		qword[rsp+0], rax
	call	lohi
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		qword [rbp-176], r12

	mov		rax, qword [rbp-312]
	mov		rax, 271733878
	mov		qword [rbp-312], rax

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, 50130
	mov		qword[rsp+8], rax
	mov		rax, 57840
	mov		qword[rsp+0], rax
	call	lohi
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		r13, r12

	mov		r15, 0

	jmp		sha1_17_forCondition

sha1_17_forCondition:
	cmp		r15, r14
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_37_forMerge
	jmp		sha1_18_forBody

sha1_18_forBody:
	mov		rax, qword [rbp-656]
	mov		rax, 16
	mov		qword [rbp-656], rax

	jmp		sha1_19_forCondition

sha1_19_forCondition:
	mov		rdx, qword [rbp-656]
	mov		rax, 80
	cmp		rdx, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_22_forMerge
	jmp		sha1_20_forBody

sha1_20_forBody:
	mov		rcx, 8
	mov		r12, r15
	imul		r12, rcx

	mov		rax, qword [global_var_chunks]
	mov		rbx, rax
	add		rbx, r12

	mov		rbx, [rbx + 0*8]

	mov		rax, qword [rbp-656]
	mov		rcx, 8
	mov		r12, rax
	imul		r12, rcx

	mov		r10, rbx
	add		r10, r12

	mov		rcx, 8
	mov		rbx, r15
	imul		rbx, rcx

	mov		rax, qword [global_var_chunks]
	mov		r12, rax
	add		r12, rbx

	mov		r12, [r12 + 0*8]

	mov		rax, qword [rbp-656]
	mov		rcx, 3
	mov		rbx, rax
	sub		rbx, rcx

	mov		rcx, 8
	imul		rbx, rcx

	add		r12, rbx

	mov		r12, [r12 + 0*8]

	mov		rcx, 8
	mov		rbx, r15
	imul		rbx, rcx

	mov		rax, qword [global_var_chunks]
	mov		r8, rax
	add		r8, rbx

	mov		r8, [r8 + 0*8]

	mov		rax, qword [rbp-656]
	mov		rcx, 8
	mov		rbx, rax
	sub		rbx, rcx

	mov		rcx, 8
	imul		rbx, rcx

	add		r8, rbx

	mov		rbx, [r8 + 0*8]

	mov		r8, r12
	xor		r8, rbx

	mov		rcx, 8
	mov		rbx, r15
	imul		rbx, rcx

	mov		rax, qword [global_var_chunks]
	mov		r12, rax
	add		r12, rbx

	mov		rbx, [r12 + 0*8]

	mov		rax, qword [rbp-656]
	mov		rcx, 14
	mov		r12, rax
	sub		r12, rcx

	mov		rcx, 8
	imul		r12, rcx

	add		rbx, r12

	mov		r12, [rbx + 0*8]

	mov		rbx, r8
	xor		rbx, r12

	mov		rcx, 8
	mov		r8, r15
	imul		r8, rcx

	mov		rax, qword [global_var_chunks]
	mov		r12, rax
	add		r12, r8

	mov		r8, [r12 + 0*8]

	mov		rax, qword [rbp-656]
	mov		rcx, 16
	mov		r12, rax
	sub		r12, rcx

	mov		rcx, 8
	imul		r12, rcx

	add		r8, r12

	mov		r12, [r8 + 0*8]

	xor		rbx, r12

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, 1
	mov		qword[rsp+8], rax
	mov		qword[rsp+0], rbx
	call	rotate_left
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		[r10 + 0 * 8], r12

	mov		r12, [r10 + 0*8]

	jmp		sha1_21_forIncrease

sha1_21_forIncrease:
	mov		rax, qword [rbp-656]
	mov		r12, rax

	mov		rax, qword [rbp-656]
	mov		rcx, 1
	mov		rdx, qword [rbp-656]
	mov		rdx, rax
	add		rdx, rcx
	mov		qword [rbp-656], rdx

	jmp		sha1_19_forCondition

sha1_22_forMerge:
	mov		qword [rbp-184], r9

	mov		r8, r11

	mov		rax, qword [rbp-176]
	mov		qword [rbp-1456], rax

	mov		rax, qword [rbp-312]
	mov		rbx, rax

	mov		qword [rbp-1304], r13

	mov		rax, qword [rbp-656]
	mov		rax, 0
	mov		qword [rbp-656], rax

	jmp		sha1_23_forCondition

sha1_23_forCondition:
	mov		rdx, qword [rbp-656]
	mov		rax, 80
	cmp		rdx, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_35_forMerge
	jmp		sha1_24_forBody

sha1_24_forBody:
	mov		rdx, qword [rbp-656]
	mov		rax, 20
	cmp		rdx, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_26_ifFalse
	jmp		sha1_25_ifTrue

sha1_25_ifTrue:
	mov		rcx, qword [rbp-1456]
	mov		r12, r8
	and		r12, rcx

	mov		r10, r8
	not 	r10

	and		r10, rbx

	or		r12, r10

	mov		r10, r12

	mov		rax, qword [rbp-808]
	mov		rax, 1518500249
	mov		qword [rbp-808], rax

	jmp		sha1_33_ifMerge

sha1_26_ifFalse:
	mov		rdx, qword [rbp-656]
	mov		rax, 40
	cmp		rdx, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_28_ifFalse
	jmp		sha1_27_ifTrue

sha1_27_ifTrue:
	mov		rcx, qword [rbp-1456]
	mov		r12, r8
	xor		r12, rcx

	xor		r12, rbx

	mov		r10, r12

	mov		rax, qword [rbp-808]
	mov		rax, 1859775393
	mov		qword [rbp-808], rax

	jmp		sha1_32_ifMerge

sha1_28_ifFalse:
	mov		rdx, qword [rbp-656]
	mov		rax, 60
	cmp		rdx, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		sha1_30_ifFalse
	jmp		sha1_29_ifTrue

sha1_29_ifTrue:
	mov		rcx, qword [rbp-1456]
	mov		r12, r8
	and		r12, rcx

	mov		r10, r8
	and		r10, rbx

	or		r12, r10

	mov		rax, qword [rbp-1456]
	mov		r10, rax
	and		r10, rbx

	or		r12, r10

	mov		r10, r12

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, 36635
	mov		qword[rsp+8], rax
	mov		rax, 48348
	mov		qword[rsp+0], rax
	call	lohi
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		qword [rbp-808], r12

	jmp		sha1_31_ifMerge

sha1_30_ifFalse:
	mov		rcx, qword [rbp-1456]
	mov		r12, r8
	xor		r12, rcx

	xor		r12, rbx

	mov		r10, r12

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, 51810
	mov		qword[rsp+8], rax
	mov		rax, 49622
	mov		qword[rsp+0], rax
	call	lohi
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		qword [rbp-808], r12

	jmp		sha1_31_ifMerge

sha1_31_ifMerge:
	jmp		sha1_32_ifMerge

sha1_32_ifMerge:
	jmp		sha1_33_ifMerge

sha1_33_ifMerge:
	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, 5
	mov		qword[rsp+8], rax
	mov		rax, qword [rbp-184]
	mov		qword[rsp+0], rax
	call	rotate_left
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, qword [rbp-1304]
	mov		qword[rsp+8], rax
	mov		qword[rsp+0], r12
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, qword [rbp-808]
	mov		qword[rsp+8], rax
	mov		qword[rsp+0], r10
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r10, rax

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+8], r10
	mov		qword[rsp+0], r12
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		qword [rbp-424], rax

	mov		rcx, 8
	mov		r12, r15
	imul		r12, rcx

	mov		rax, qword [global_var_chunks]
	mov		r10, rax
	add		r10, r12

	mov		r12, [r10 + 0*8]

	mov		rax, qword [rbp-656]
	mov		rcx, 8
	mov		r10, rax
	imul		r10, rcx

	add		r12, r10

	mov		r12, [r12 + 0*8]

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+8], r12
	mov		rax, qword [rbp-424]
	mov		qword[rsp+0], rax
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		r10, r12

	mov		qword [rbp-1304], rbx

	mov		rax, qword [rbp-1456]
	mov		rbx, rax

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, 30
	mov		qword[rsp+8], rax
	mov		qword[rsp+0], r8
	call	rotate_left
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		qword [rbp-1456], r12

	mov		rax, qword [rbp-184]
	mov		r8, rax

	mov		qword [rbp-184], r10

	jmp		sha1_34_forIncrease

sha1_34_forIncrease:
	mov		rax, qword [rbp-656]
	mov		r12, rax

	mov		rax, qword [rbp-656]
	mov		rcx, 1
	mov		rdx, qword [rbp-656]
	mov		rdx, rax
	add		rdx, rcx
	mov		qword [rbp-656], rdx

	jmp		sha1_23_forCondition

sha1_35_forMerge:
	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, qword [rbp-184]
	mov		qword[rsp+8], rax
	mov		qword[rsp+0], r9
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		r9, r12

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+8], r8
	mov		qword[rsp+0], r11
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		r11, r12

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, qword [rbp-1456]
	mov		qword[rsp+8], rax
	mov		rax, qword [rbp-176]
	mov		qword[rsp+0], rax
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		qword [rbp-176], r12

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+8], rbx
	mov		rax, qword [rbp-312]
	mov		qword[rsp+0], rax
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		qword [rbp-312], r12

	mov		qword[rsp-80], r10
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	mov		qword[rsp-88], r11
	sub		rsp, 128
	sub		rsp, 16
	mov		rax, qword [rbp-1304]
	mov		qword[rsp+8], rax
	mov		qword[rsp+0], r13
	call	add
	add		rsp, 16
	add		rsp, 128
	mov		r10, qword[rsp-80]
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r11, qword[rsp-88]
	mov		r12, rax

	mov		r13, r12

	jmp		sha1_36_forIncrease

sha1_36_forIncrease:
	mov		r12, r15

	mov		rcx, 1
	add		r15, rcx

	jmp		sha1_17_forCondition

sha1_37_forMerge:
	mov		rax, 0
	mov		rcx, 8
	mov		r12, rax
	imul		r12, rcx

	mov		rax, qword [global_var_outputBuffer]
	mov		r14, rax
	add		r14, r12

	mov		[r14 + 0 * 8], r9

	mov		r12, [r14 + 0*8]

	mov		rax, 1
	mov		rcx, 8
	mov		r14, rax
	imul		r14, rcx

	mov		rax, qword [global_var_outputBuffer]
	mov		r12, rax
	add		r12, r14

	mov		[r12 + 0 * 8], r11

	mov		r12, [r12 + 0*8]

	mov		rax, 2
	mov		rcx, 8
	mov		r14, rax
	imul		r14, rcx

	mov		rax, qword [global_var_outputBuffer]
	mov		r12, rax
	add		r12, r14

	mov		rdx, qword [rbp-176]
	mov		[r12 + 0 * 8], rdx

	mov		r12, [r12 + 0*8]

	mov		rax, 3
	mov		rcx, 8
	mov		r14, rax
	imul		r14, rcx

	mov		rax, qword [global_var_outputBuffer]
	mov		r12, rax
	add		r12, r14

	mov		rdx, qword [rbp-312]
	mov		[r12 + 0 * 8], rdx

	mov		r12, [r12 + 0*8]

	mov		rax, 4
	mov		rcx, 8
	mov		r12, rax
	imul		r12, rcx

	mov		rax, qword [global_var_outputBuffer]
	mov		r14, rax
	add		r14, r12

	mov		[r14 + 0 * 8], r13

	mov		r12, [r14 + 0*8]

	mov		rax, qword [global_var_outputBuffer]
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		rbx, qword[rsp-24]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		sha1_38_exit

sha1_38_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		rbx, qword[rsp-24]
	mov		r14, qword[rsp-112]
	leave
	ret


computeSHA1:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 288
	mov		qword[rsp-96], r12
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	sub		rsp, 128
computeSHA1_0_beginning:
	jmp		computeSHA1_1_entry

computeSHA1_1_entry:
	mov		r13, 0

	jmp		computeSHA1_2_forCondition

computeSHA1_2_forCondition:
	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	call	FBH_string_length
	add		rsp, 128
	mov		r12, rax

	cmp		r13, r12
	setl		al
	movzx	r14, al

	test	r14, r14
	jz		computeSHA1_5_forMerge
	jmp		computeSHA1_3_forBody

computeSHA1_3_forBody:
	mov		rcx, 8
	mov		r12, r13
	imul		r12, rcx

	mov		rax, qword [global_var_inputBuffer]
	mov		r14, rax
	add		r14, r12

	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	mov		rsi, r13
	call	FBH_string_ord
	add		rsp, 128
	mov		r12, rax

	mov		[r14 + 0 * 8], r12

	mov		r12, [r14 + 0*8]

	jmp		computeSHA1_4_forIncrease

computeSHA1_4_forIncrease:
	mov		r12, r13

	mov		rcx, 1
	add		r13, rcx

	jmp		computeSHA1_2_forCondition

computeSHA1_5_forMerge:
	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	call	FBH_string_length
	add		rsp, 128
	mov		r12, rax

	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+8], r12
	mov		rax, qword [global_var_inputBuffer]
	mov		qword[rsp+0], rax
	call	sha1
	add		rsp, 16
	add		rsp, 128
	mov		r12, rax

	mov		r14, r12

	mov		r13, 0

	jmp		computeSHA1_6_forCondition

computeSHA1_6_forCondition:
	sub		rsp, 128
	mov		rdi, r14
	call	FBH_array_size
	add		rsp, 128
	mov		r12, rax

	cmp		r13, r12
	setl		al
	movzx	r15, al

	test	r15, r15
	jz		computeSHA1_9_forMerge
	jmp		computeSHA1_7_forBody

computeSHA1_7_forBody:
	mov		rcx, 8
	mov		r12, r13
	imul		r12, rcx

	mov		r15, r14
	add		r15, r12

	mov		r12, [r15 + 0*8]

	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+0], r12
	call	toStringHex
	add		rsp, 16
	add		rsp, 128
	mov		r12, rax

	sub		rsp, 128
	mov		rdi, r12
	call	FBH_print
	add		rsp, 128

	jmp		computeSHA1_8_forIncrease

computeSHA1_8_forIncrease:
	mov		r12, r13

	mov		rcx, 1
	add		r13, rcx

	jmp		computeSHA1_6_forCondition

computeSHA1_9_forMerge:
	sub		rsp, 128
	mov		rdi, ___message___335
	call	FBH_println
	add		rsp, 128

	jmp		computeSHA1_10_exit

computeSHA1_10_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret


nextLetter:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 176
	mov		qword[rsp-96], r12
	sub		rsp, 128
nextLetter_0_beginning:
	jmp		nextLetter_1_entry

nextLetter_1_entry:
	mov		rdx, qword [rbp+16]
	mov		rax, 122
	cmp		rdx, rax
	sete		al
	movzx	r12, al

	test	r12, r12
	jz		nextLetter_3_ifFalse
	jmp		nextLetter_2_ifTrue

nextLetter_2_ifTrue:
	mov		rax, -1
	add		rsp, 128
	mov		r12, qword[rsp-96]
	leave
	ret

	jmp		nextLetter_11_exit

nextLetter_3_ifFalse:
	jmp		nextLetter_4_ifMerge

nextLetter_4_ifMerge:
	mov		rdx, qword [rbp+16]
	mov		rax, 90
	cmp		rdx, rax
	sete		al
	movzx	r12, al

	test	r12, r12
	jz		nextLetter_6_ifFalse
	jmp		nextLetter_5_ifTrue

nextLetter_5_ifTrue:
	mov		rax, 97
	add		rsp, 128
	mov		r12, qword[rsp-96]
	leave
	ret

	jmp		nextLetter_11_exit

nextLetter_6_ifFalse:
	jmp		nextLetter_7_ifMerge

nextLetter_7_ifMerge:
	mov		rdx, qword [rbp+16]
	mov		rax, 57
	cmp		rdx, rax
	sete		al
	movzx	r12, al

	test	r12, r12
	jz		nextLetter_9_ifFalse
	jmp		nextLetter_8_ifTrue

nextLetter_8_ifTrue:
	mov		rax, 65
	add		rsp, 128
	mov		r12, qword[rsp-96]
	leave
	ret

	jmp		nextLetter_11_exit

nextLetter_9_ifFalse:
	jmp		nextLetter_10_ifMerge

nextLetter_10_ifMerge:
	mov		rax, qword [rbp+16]
	mov		rcx, 1
	mov		r12, rax
	add		r12, rcx

	mov		rax, r12
	add		rsp, 128
	mov		r12, qword[rsp-96]
	leave
	ret

	jmp		nextLetter_11_exit

nextLetter_11_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	leave
	ret


nextText:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 288
	mov		qword[rsp-96], r12
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	sub		rsp, 128
nextText_0_beginning:
	jmp		nextText_1_entry

nextText_1_entry:
	mov		rax, qword [rbp+24]
	mov		rcx, 1
	mov		r12, rax
	sub		r12, rcx


	jmp		nextText_2_forCondition

nextText_2_forCondition:
	mov		rax, 0
	cmp		r12, rax
	setge		al
	movzx	r13, al

	test	r13, r13
	jz		nextText_8_forMerge
	jmp		nextText_3_forBody

nextText_3_forBody:
	mov		rcx, 8
	mov		r13, r12
	imul		r13, rcx

	mov		rax, qword [rbp+16]
	mov		r15, rax
	add		r15, r13

	mov		rcx, 8
	mov		r14, r12
	imul		r14, rcx

	mov		rax, qword [rbp+16]
	mov		r13, rax
	add		r13, r14

	mov		r13, [r13 + 0*8]

	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+0], r13
	call	nextLetter
	add		rsp, 16
	add		rsp, 128
	mov		r13, rax

	mov		[r15 + 0 * 8], r13

	mov		r13, [r15 + 0*8]

	mov		rcx, 8
	mov		r13, r12
	imul		r13, rcx

	mov		rax, qword [rbp+16]
	mov		r14, rax
	add		r14, r13

	mov		r13, [r14 + 0*8]

	mov		rax, -1
	cmp		r13, rax
	sete		al
	movzx	r13, al

	test	r13, r13
	jz		nextText_5_ifFalse
	jmp		nextText_4_ifTrue

nextText_4_ifTrue:
	mov		rcx, 8
	mov		r14, r12
	imul		r14, rcx

	mov		rax, qword [rbp+16]
	mov		r13, rax
	add		r13, r14

	mov		rdx, 48
	mov		[r13 + 0 * 8], rdx

	mov		r13, [r13 + 0*8]

	jmp		nextText_6_ifMerge

nextText_5_ifFalse:
	mov		rax, 1
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		nextText_9_exit

nextText_6_ifMerge:
	jmp		nextText_7_forIncrease

nextText_7_forIncrease:
	mov		r13, r12

	mov		rcx, 1
	sub		r12, rcx

	jmp		nextText_2_forCondition

nextText_8_forMerge:
	mov		rax, 0
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		nextText_9_exit

nextText_9_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret


array_equal:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 256
	mov		qword[rsp-96], r12
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	sub		rsp, 128
array_equal_0_beginning:
	jmp		array_equal_1_entry

array_equal_1_entry:
	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	call	FBH_array_size
	add		rsp, 128
	mov		r12, rax

	sub		rsp, 128
	mov		rdi, qword [rbp+24]
	call	FBH_array_size
	add		rsp, 128
	mov		r13, rax

	cmp		r12, r13
	setne		al
	movzx	r12, al

	test	r12, r12
	jz		array_equal_3_ifFalse
	jmp		array_equal_2_ifTrue

array_equal_2_ifTrue:
	mov		rax, 0
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		array_equal_12_exit

array_equal_3_ifFalse:
	jmp		array_equal_4_ifMerge

array_equal_4_ifMerge:
	mov		r12, 0

	jmp		array_equal_5_forCondition

array_equal_5_forCondition:
	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	call	FBH_array_size
	add		rsp, 128
	mov		r13, rax

	cmp		r12, r13
	setl		al
	movzx	r14, al

	test	r14, r14
	jz		array_equal_11_forMerge
	jmp		array_equal_6_forBody

array_equal_6_forBody:
	mov		rcx, 8
	mov		r13, r12
	imul		r13, rcx

	mov		rax, qword [rbp+16]
	mov		r14, rax
	add		r14, r13

	mov		r13, [r14 + 0*8]

	mov		rcx, 8
	mov		r14, r12
	imul		r14, rcx

	mov		rax, qword [rbp+24]
	mov		r15, rax
	add		r15, r14

	mov		r14, [r15 + 0*8]

	cmp		r13, r14
	setne		al
	movzx	r13, al

	test	r13, r13
	jz		array_equal_8_ifFalse
	jmp		array_equal_7_ifTrue

array_equal_7_ifTrue:
	mov		rax, 0
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		array_equal_12_exit

array_equal_8_ifFalse:
	jmp		array_equal_9_ifMerge

array_equal_9_ifMerge:
	jmp		array_equal_10_forIncrease

array_equal_10_forIncrease:
	mov		r13, r12

	mov		rcx, 1
	add		r12, rcx

	jmp		array_equal_5_forCondition

array_equal_11_forMerge:
	mov		rax, 1
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		array_equal_12_exit

array_equal_12_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret


crackSHA1:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 544
	mov		qword[rsp-96], r12
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	mov		qword[rsp-24], rbx
	sub		rsp, 128
crackSHA1_0_beginning:
	jmp		crackSHA1_1_entry

crackSHA1_1_entry:
	mov		rax, 5
	mov		rcx, 8
	mov		r12, rax
	imul		r12, rcx

	mov		rcx, 8
	add		r12, rcx

	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	mov		rdi, r12
	call	malloc
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r13, rax

	mov		rcx, 8
	sub		r12, rcx

	mov		rdx, 5
	mov		[r13 + 0 * 8], rdx

	mov		rcx, 8
	add		r13, rcx

	mov		r12, r13

	mov		rbx, r12

	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	call	FBH_string_length
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r12, rax

	mov		rax, 40
	cmp		r12, rax
	setne		al
	movzx	r12, al

	test	r12, r12
	jz		crackSHA1_3_ifFalse
	jmp		crackSHA1_2_ifTrue

crackSHA1_2_ifTrue:
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	mov		rdi, ___message___375
	call	FBH_println
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]

	jmp		crackSHA1_34_exit

crackSHA1_3_ifFalse:
	jmp		crackSHA1_4_ifMerge

crackSHA1_4_ifMerge:
	mov		r14, 0

	jmp		crackSHA1_5_forCondition

crackSHA1_5_forCondition:
	mov		rax, 5
	cmp		r14, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		crackSHA1_8_forMerge
	jmp		crackSHA1_6_forBody

crackSHA1_6_forBody:
	mov		rcx, 8
	mov		r13, r14
	imul		r13, rcx

	mov		r12, rbx
	add		r12, r13

	mov		rdx, 0
	mov		[r12 + 0 * 8], rdx

	mov		r12, [r12 + 0*8]

	jmp		crackSHA1_7_forIncrease

crackSHA1_7_forIncrease:
	mov		r12, r14

	mov		rcx, 1
	add		r14, rcx

	jmp		crackSHA1_5_forCondition

crackSHA1_8_forMerge:
	mov		r14, 0

	jmp		crackSHA1_9_forCondition

crackSHA1_9_forCondition:
	mov		rax, 40
	cmp		r14, rax
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		crackSHA1_12_forMerge
	jmp		crackSHA1_10_forBody

crackSHA1_10_forBody:
	mov		rax, r14
	mov		rcx, 8
	cqo
	idiv	rcx
	mov		r12, rax

	mov		rcx, 8
	imul		r12, rcx

	mov		r8, rbx
	add		r8, r12

	mov		rax, r14
	mov		rcx, 8
	cqo
	idiv	rcx
	mov		r12, rax

	mov		rcx, 8
	mov		r13, r12
	imul		r13, rcx

	mov		r12, rbx
	add		r12, r13

	mov		r12, [r12 + 0*8]

	mov		rcx, 3
	mov		r13, r14
	add		r13, rcx

	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	mov		rdi, qword [rbp+16]
	mov		rsi, r14
	mov		rdx, r13
	call	FBH_string_substring
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r13, rax

	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+0], r13
	call	hex2int
	add		rsp, 16
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r15, rax

	mov		rax, r14
	mov		rcx, 4
	cqo
	idiv	rcx
	mov		r13, rax

	mov		rax, r13
	mov		rcx, 2
	cqo
	idiv	rcx
	mov		r9, rdx

	mov		rax, 1
	mov		r13, rax
	sub		r13, r9

	mov		rcx, 16
	imul		r13, rcx

	mov		rax, r15
	mov		rcx, r13
	sal		rax, cl
	mov		r15, rax

	or		r12, r15

	mov		[r8 + 0 * 8], r12

	mov		r12, [r8 + 0*8]

	jmp		crackSHA1_11_forIncrease

crackSHA1_11_forIncrease:
	mov		rcx, 4
	mov		r12, r14
	add		r12, rcx

	mov		r14, r12

	jmp		crackSHA1_9_forCondition

crackSHA1_12_forMerge:
	mov		r12, 4

	mov		r15, 1

	jmp		crackSHA1_13_forCondition

crackSHA1_13_forCondition:
	cmp		r15, r12
	setle		al
	movzx	r13, al

	test	r13, r13
	jz		crackSHA1_33_forMerge
	jmp		crackSHA1_14_forBody

crackSHA1_14_forBody:
	mov		r14, 0

	jmp		crackSHA1_15_forCondition

crackSHA1_15_forCondition:
	cmp		r14, r15
	setl		al
	movzx	r13, al

	test	r13, r13
	jz		crackSHA1_18_forMerge
	jmp		crackSHA1_16_forBody

crackSHA1_16_forBody:
	mov		rcx, 8
	mov		r8, r14
	imul		r8, rcx

	mov		rax, qword [global_var_inputBuffer]
	mov		r13, rax
	add		r13, r8

	mov		rdx, 48
	mov		[r13 + 0 * 8], rdx

	mov		r13, [r13 + 0*8]

	jmp		crackSHA1_17_forIncrease

crackSHA1_17_forIncrease:
	mov		r13, r14

	mov		rcx, 1
	add		r14, rcx

	jmp		crackSHA1_15_forCondition

crackSHA1_18_forMerge:
	jmp		crackSHA1_19_whileCondition

crackSHA1_19_whileCondition:
	mov		rax, 1
	test	rax, rax
	jz		crackSHA1_31_whileMerge
	jmp		crackSHA1_20_whileBody

crackSHA1_20_whileBody:
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+8], r15
	mov		rax, qword [global_var_inputBuffer]
	mov		qword[rsp+0], rax
	call	sha1
	add		rsp, 16
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r13, rax


	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+8], rbx
	mov		qword[rsp+0], r13
	call	array_equal
	add		rsp, 16
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r13, rax

	test	r13, r13
	jz		crackSHA1_26_ifFalse
	jmp		crackSHA1_21_ifTrue

crackSHA1_21_ifTrue:
	mov		r14, 0

	jmp		crackSHA1_22_forCondition

crackSHA1_22_forCondition:
	cmp		r14, r15
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		crackSHA1_25_forMerge
	jmp		crackSHA1_23_forBody

crackSHA1_23_forBody:
	mov		rcx, 8
	mov		r12, r14
	imul		r12, rcx

	mov		rax, qword [global_var_inputBuffer]
	mov		r13, rax
	add		r13, r12

	mov		r12, [r13 + 0*8]

	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+0], r12
	call	int2chr
	add		rsp, 16
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r12, rax

	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	mov		rdi, r12
	call	FBH_print
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]

	jmp		crackSHA1_24_forIncrease

crackSHA1_24_forIncrease:
	mov		r12, r14

	mov		rcx, 1
	add		r14, rcx

	jmp		crackSHA1_22_forCondition

crackSHA1_25_forMerge:
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	mov		rdi, ___message___414
	call	FBH_println
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]

	jmp		crackSHA1_34_exit

crackSHA1_26_ifFalse:
	jmp		crackSHA1_27_ifMerge

crackSHA1_27_ifMerge:
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+8], r15
	mov		rax, qword [global_var_inputBuffer]
	mov		qword[rsp+0], rax
	call	nextText
	add		rsp, 16
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]
	mov		r13, rax

	mov		rcx, 1
	xor		r13, rcx

	test	r13, r13
	jz		crackSHA1_29_ifFalse
	jmp		crackSHA1_28_ifTrue

crackSHA1_28_ifTrue:
	jmp		crackSHA1_31_whileMerge

crackSHA1_29_ifFalse:
	jmp		crackSHA1_30_ifMerge

crackSHA1_30_ifMerge:
	jmp		crackSHA1_19_whileCondition

crackSHA1_31_whileMerge:
	jmp		crackSHA1_32_forIncrease

crackSHA1_32_forIncrease:
	mov		r13, r15

	mov		rcx, 1
	add		r15, rcx

	jmp		crackSHA1_13_forCondition

crackSHA1_33_forMerge:
	mov		qword[rsp-72], r9
	mov		qword[rsp-64], r8
	sub		rsp, 128
	mov		rdi, ___message___418
	call	FBH_println
	add		rsp, 128
	mov		r9, qword[rsp-72]
	mov		r8, qword[rsp-64]

	jmp		crackSHA1_34_exit

crackSHA1_34_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	mov		rbx, qword[rsp-24]
	leave
	ret


main:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 320
	mov		qword[rsp-96], r12
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	mov		qword[rsp-24], rbx
	sub		rsp, 128
main_0_beginning:
	mov		rax, ___message___419
	mov		qword [global_var_asciiTable], rax

	mov		rax, 100
	mov		qword [global_var_MAXCHUNK], rax

	mov		rax, qword [global_var_MAXCHUNK]
	mov		rcx, 1
	mov		r12, rax
	sub		r12, rcx

	mov		rcx, 64
	imul		r12, rcx

	mov		rcx, 16
	sub		r12, rcx

	mov		qword [global_var_MAXLENGTH], r12

	mov		rax, qword [global_var_MAXCHUNK]
	mov		rcx, 8
	mov		r14, rax
	imul		r14, rcx

	mov		rcx, 8
	add		r14, rcx

	sub		rsp, 128
	mov		rdi, r14
	call	malloc
	add		rsp, 128
	mov		r15, rax

	mov		rcx, 8
	sub		r14, rcx

	mov		rdx, qword [global_var_MAXCHUNK]
	mov		[r15 + 0 * 8], rdx

	mov		rcx, 8
	add		r15, rcx

	mov		r13, r15

	mov		r12, r15
	add		r12, r14

	jmp		main_1_whileCondition

main_1_whileCondition:
	cmp		r15, r12
	setne		al
	movzx	r14, al

	test	r14, r14
	jz		main_3_whileMerge
	jmp		main_2_whileBody

main_2_whileBody:
	mov		rax, 80
	mov		rcx, 8
	mov		rbx, rax
	imul		rbx, rcx

	mov		rcx, 8
	add		rbx, rcx

	sub		rsp, 128
	mov		rdi, rbx
	call	malloc
	add		rsp, 128
	mov		r14, rax

	mov		rcx, 8
	sub		rbx, rcx

	mov		rdx, 80
	mov		[r14 + 0 * 8], rdx

	mov		rcx, 8
	add		r14, rcx

	mov		[r15 + 0 * 8], r14

	mov		rcx, 8
	add		r15, rcx

	jmp		main_1_whileCondition

main_3_whileMerge:
	mov		qword [global_var_chunks], r13

	mov		rax, qword [global_var_MAXLENGTH]
	mov		rcx, 8
	mov		r12, rax
	imul		r12, rcx

	mov		rcx, 8
	add		r12, rcx

	sub		rsp, 128
	mov		rdi, r12
	call	malloc
	add		rsp, 128
	mov		r13, rax

	mov		rcx, 8
	sub		r12, rcx

	mov		rdx, qword [global_var_MAXLENGTH]
	mov		[r13 + 0 * 8], rdx

	mov		rcx, 8
	add		r13, rcx

	mov		r12, r13

	mov		qword [global_var_inputBuffer], r12

	mov		rax, 5
	mov		rcx, 8
	mov		r12, rax
	imul		r12, rcx

	mov		rcx, 8
	add		r12, rcx

	sub		rsp, 128
	mov		rdi, r12
	call	malloc
	add		rsp, 128
	mov		r13, rax

	mov		rcx, 8
	sub		r12, rcx

	mov		rdx, 5
	mov		[r13 + 0 * 8], rdx

	mov		rcx, 8
	add		r13, rcx

	mov		r12, r13

	mov		qword [global_var_outputBuffer], r12

	jmp		main_4_entry

main_4_entry:
	jmp		main_5_whileCondition

main_5_whileCondition:
	mov		rax, 1
	test	rax, rax
	jz		main_16_whileMerge
	jmp		main_6_whileBody

main_6_whileBody:
	sub		rsp, 128
	call	FBH_getInt
	add		rsp, 128
	mov		r12, rax

	mov		r13, r12

	mov		rax, 0
	cmp		r13, rax
	sete		al
	movzx	r12, al

	test	r12, r12
	jz		main_8_ifFalse
	jmp		main_7_ifTrue

main_7_ifTrue:
	jmp		main_16_whileMerge

main_8_ifFalse:
	jmp		main_9_ifMerge

main_9_ifMerge:
	mov		rax, 1
	cmp		r13, rax
	sete		al
	movzx	r12, al

	test	r12, r12
	jz		main_11_ifFalse
	jmp		main_10_ifTrue

main_10_ifTrue:
	sub		rsp, 128
	call	FBH_getString
	add		rsp, 128
	mov		r12, rax


	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+0], r12
	call	computeSHA1
	add		rsp, 16
	add		rsp, 128

	jmp		main_15_ifMerge

main_11_ifFalse:
	mov		rax, 2
	cmp		r13, rax
	sete		al
	movzx	r12, al

	test	r12, r12
	jz		main_13_ifFalse
	jmp		main_12_ifTrue

main_12_ifTrue:
	sub		rsp, 128
	call	FBH_getString
	add		rsp, 128
	mov		r12, rax


	sub		rsp, 128
	sub		rsp, 16
	mov		qword[rsp+0], r12
	call	crackSHA1
	add		rsp, 16
	add		rsp, 128

	jmp		main_14_ifMerge

main_13_ifFalse:
	jmp		main_14_ifMerge

main_14_ifMerge:
	jmp		main_15_ifMerge

main_15_ifMerge:
	jmp		main_5_whileCondition

main_16_whileMerge:
	mov		rax, 0
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	mov		rbx, qword[rsp-24]
	leave
	ret

	jmp		main_17_exit

main_17_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	mov		rbx, qword[rsp-24]
	leave
	ret


print_Int:
     mov                  rsi,                  rdi
     mov                  rdi,        __printFormat
     sub                  rsp,                    8
    call               printf
     add                  rsp,                    8
     ret
println_Int:
     mov                  rsi,                  rdi
     mov                  rdi,        __printFormat
     sub                  rsp,                    8
    call               printf
     add                  rsp,                    8
     ret
FBH_print:
     mov                  rsi,                  rdi
     mov                  rdi,        __printFormat
     sub                  rsp,                    8
    call               printf
     add                  rsp,                    8
     ret
FBH_println:
     sub                  rsp,                    8
    call                 puts
     add                  rsp,                    8
     ret
FBH_getInt:
     mov                  rdi,       __getIntFormat
     mov                  rsi,           @getIntBuf
     sub                  rsp,                    8
    call                scanf
     add                  rsp,                    8
     mov                  rax,   qword [@getIntBuf]
     ret
FBH_getString:
    push                  r15
     mov                  rdi,                  300
    call               malloc
     mov                  r15,                  rax
     add                  r15,                    8
     mov                  rdi,    __getStringFormat
     mov                  rsi,                  r15
    call                scanf
     mov                  rdi,                  r15
    call               strlen
     mov      qword [r15 - 8],                  rax
     mov                  rax,                  r15
     pop                  r15
     ret
FBH_toString:
    push                  r15
    push                  rdi
     mov                  rdi,                   20
     sub                  rsp,                    8
    call               malloc
     add                  rsp,                    8
     mov                  r15,                  rax
     add                  r15,                    8
     mov                  rdi,                  r15
     mov                  rsi,     __toStringFormat
     pop                  rdx
    call              sprintf
     mov                  rdi,                  r15
    call               strlen
     mov      qword [r15 - 8],                  rax
     mov                  rax,                  r15
     pop                  r15
     ret
FBH_array_size:
     mov                  rax,      qword [rdi - 8]
     ret
FBH_string_length:
     mov                  rax,      qword [rdi - 8]
     ret
FBH_string_parseInt:
     mov                  rsi,       __getIntFormat
     mov                  rdx,         @parseIntBuf
     sub                  rsp,                    8
    call               sscanf
     add                  rsp,                    8
     mov                  rax, qword [@parseIntBuf]
     ret
FBH_string_substring:
    push                  r15
    push                  r14
     mov                  r15,                  rdi
     add                  r15,                  rsi
     mov                  r14,                  rdx
     sub                  r14,                  rsi
     add                  r14,                    1
     mov                  rdi,                  r14
     add                  rdi,                    9
     sub                  rsp,                    8
    call               malloc
     add                  rsp,                    8
     add                  rax,                    8
     mov                  rdi,                  rax
     mov                  rsi,                  r15
     mov                  rdx,                  r14
     sub                  rsp,                    8
    call               memcpy
     add                  rsp,                    8
     mov      qword [rax - 8],                  r14
     mov                  r15,                  rax
     add                  r15,                  r14
     mov                  r15,                    0
     pop                  r14
     pop                  r15
     ret
FBH_string_ord:
     add                  rdi,                  rsi
   movsx                  rax,           byte [rdi]
     ret
FBH_string_connect:
    push                  r15
    push                  r14
    push                  r13
     mov                  r15,      qword [rdi - 8]
     add                  r15,      qword [rsi - 8]
     add                  r15,                    9
     mov                  r14,                  rdi
     mov                  r13,                  rsi
     mov                  rdi,                  r15
    call               malloc
     sub                  r15,                    9
     mov          qword [rax],                  r15
     mov                  r15,                  rax
     add                  r15,                    8
     mov                  rdi,                  r15
     mov                  rsi,                  r14
    call               strcpy
     add                  r15,      qword [r14 - 8]
     mov                  r14,                  rax
     mov                  rdi,                  r15
     mov                  rsi,                  r13
    call               strcpy
     mov                  rax,                  r14
     pop                  r13
     pop                  r14
     pop                  r15
     ret
FBH_string_e:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
    sete                   al
     ret
FBH_string_ne:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
   setne                   al
     ret
FBH_string_g:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
    setg                   al
     ret
FBH_string_ge:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
   setge                   al
     ret
FBH_string_l:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
    setl                   al
     ret
FBH_string_le:
     sub                  rsp,                    8
    call               strcmp
     add                  rsp,                    8
     cmp                  eax,                    0
     mov                  rax,                    0
   setle                   al
     ret

SECTION .data
      dq                   10
___message___418:
      db      "Not Found!", 0
      dq                    0
___message___86:
      db                "", 0
      dq                   13
___message___375:
      db   "Invalid input", 0
      dq                    0
___message___335:
      db                "", 0
      dq                   18
___message___143:
      db "nChunk > MAXCHUNK!", 0
      dq                   97
___message___419:
      db " !", 34, "#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[", 92, "]^_`abcdefghijklmnopqrstuvwxyz{|}~", 0
      dq                    0
___message___85:
      db                "", 0
      dq                    0
___message___414:
      db                "", 0
__println_IntFormat:
      db         "%ld", 10, 0
__print_IntFormat:
      db             "%ld", 0
__printFormat:
      db              "%s", 0
__getIntFormat:
      db             "%ld", 0
__getStringFormat:
      db              "%s", 0
__toStringFormat:
      db             "%ld", 0
__parseIntFormat:
      db             "%ld", 0

SECTION .bss
global_var_asciiTable:
    resq                    1
global_var_MAXCHUNK:
    resq                    1
global_var_MAXLENGTH:
    resq                    1
global_var_chunks:
    resq                    1
global_var_inputBuffer:
    resq                    1
global_var_outputBuffer:
    resq                    1
@getIntBuf:
    resq                    1
@parseIntBuf:
    resq                    1

