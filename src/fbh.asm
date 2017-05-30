	default rel

	global func
	global main

extern printf, malloc, strcpy, scanf, strlen, sscanf, sprintf, memcpy, strcmp, puts

	SECTION .text

func:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 176
	mov		qword[rsp-24], rbx
	sub		rsp, 128
func_0_beginning:
	jmp		func_1_entry

func_1_entry:
	mov		rax, qword [rbp+16]
	mov		rcx, qword [rbp+24]
	add		rax, rcx
	mov		rbx, rax

	mov		rcx, qword [rbp+32]
	mov		rax, rbx
	add		rax, rcx
	mov		rbx, rax

	mov		rcx, 1073741823
	mov		rax, rbx
	and		rax, rcx
	mov		rbx, rax

	mov		rax, rbx
	add		rsp, 128
	mov		rbx, qword[rsp-24]
	leave
	ret

	jmp		func_2_exit

func_2_exit:
	add		rsp, 128
	mov		rbx, qword[rsp-24]
	leave
	ret


main:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 1360
main_0_beginning:
	jmp		main_1_entry

main_1_entry:
	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	call	FBH_getInt
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		rbx, rax

	mov		r12, rbx

	mov		rcx, 8
	mov		rax, r12
	imul		rax, rcx
	mov		rbx, rax

	mov		rcx, 8
	mov		rax, rbx
	add		rax, rcx
	mov		rbx, rax

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	mov		rdi, rbx
	call	malloc
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r9, rax

	mov		rcx, 8
	mov		rax, rbx
	sub		rax, rcx
	mov		rbx, rax

	mov		[r9 + 0 * 8], r12

	mov		rcx, 8
	mov		rax, r9
	add		rax, rcx
	mov		r9, rax

	mov		r10, r9

	mov		rax, r9
	add		rax, rbx
	mov		r11, rax

	jmp		main_2_whileCondition

main_2_whileCondition:
	cmp		r9, r11
	setne		al
	movzx	rbx, al

	test	rbx, rbx
	jz		main_4_whileMerge
	jmp		main_3_whileBody

main_3_whileBody:
	mov		rcx, 8
	mov		rax, r12
	imul		rax, rcx
	mov		r8, rax

	mov		rcx, 8
	mov		rax, r8
	add		rax, rcx
	mov		r8, rax

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	mov		rdi, r8
	call	malloc
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		rbx, rax

	mov		rcx, 8
	mov		rax, r8
	sub		rax, rcx
	mov		r8, rax

	mov		[rbx + 0 * 8], r12

	mov		rcx, 8
	mov		rax, rbx
	add		rax, rcx
	mov		rbx, rax

	mov		[r9 + 0 * 8], rbx

	mov		rcx, 8
	mov		rax, r9
	add		rax, rcx
	mov		r9, rax

	jmp		main_2_whileCondition

main_4_whileMerge:
	mov		rbx, r10

	mov		rcx, 8
	mov		rax, r12
	imul		rax, rcx
	mov		r8, rax

	mov		rcx, 8
	mov		rax, r8
	add		rax, rcx
	mov		r8, rax

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	mov		rdi, r8
	call	malloc
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r13, rax

	mov		rcx, 8
	mov		rax, r8
	sub		rax, rcx
	mov		r8, rax

	mov		[r13 + 0 * 8], r12

	mov		rcx, 8
	mov		rax, r13
	add		rax, rcx
	mov		r13, rax

	mov		r9, r13

	mov		rax, r13
	add		rax, r8
	mov		r10, rax

	jmp		main_5_whileCondition

main_5_whileCondition:
	cmp		r13, r10
	setne		al
	movzx	r8, al

	test	r8, r8
	jz		main_7_whileMerge
	jmp		main_6_whileBody

main_6_whileBody:
	mov		rcx, 8
	mov		rax, r12
	imul		rax, rcx
	mov		r11, rax

	mov		rcx, 8
	mov		rax, r11
	add		rax, rcx
	mov		r11, rax

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	mov		rdi, r11
	call	malloc
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r8, rax

	mov		rcx, 8
	mov		rax, r11
	sub		rax, rcx
	mov		r11, rax

	mov		[r8 + 0 * 8], r12

	mov		rcx, 8
	mov		rax, r8
	add		rax, rcx
	mov		r8, rax

	mov		[r13 + 0 * 8], r8

	mov		rcx, 8
	mov		rax, r13
	add		rax, rcx
	mov		r13, rax

	jmp		main_5_whileCondition

main_7_whileMerge:
	mov		r15, r9

	mov		rcx, 8
	mov		rax, r12
	imul		rax, rcx
	mov		r9, rax

	mov		rcx, 8
	mov		rax, r9
	add		rax, rcx
	mov		r9, rax

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	mov		rdi, r9
	call	malloc
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r8, rax

	mov		rcx, 8
	mov		rax, r9
	sub		rax, rcx
	mov		r9, rax

	mov		[r8 + 0 * 8], r12

	mov		rcx, 8
	mov		rax, r8
	add		rax, rcx
	mov		r8, rax

	mov		r10, r8

	mov		rax, r8
	add		rax, r9
	mov		r11, rax

	jmp		main_8_whileCondition

main_8_whileCondition:
	cmp		r8, r11
	setne		al
	movzx	r9, al

	test	r9, r9
	jz		main_10_whileMerge
	jmp		main_9_whileBody

main_9_whileBody:
	mov		rcx, 8
	mov		rax, r12
	imul		rax, rcx
	mov		r9, rax

	mov		rcx, 8
	mov		rax, r9
	add		rax, rcx
	mov		r9, rax

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	mov		rdi, r9
	call	malloc
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r13, rax

	mov		rcx, 8
	mov		rax, r9
	sub		rax, rcx
	mov		r9, rax

	mov		[r13 + 0 * 8], r12

	mov		rcx, 8
	mov		rax, r13
	add		rax, rcx
	mov		r13, rax

	mov		[r8 + 0 * 8], r13

	mov		rcx, 8
	mov		rax, r8
	add		rax, rcx
	mov		r8, rax

	jmp		main_8_whileCondition

main_10_whileMerge:
	mov		r9, r10

	mov		rax, qword [rbp-1128]
	mov		rax, 0
	mov		qword [rbp-1128], rax

	jmp		main_11_forCondition

main_11_forCondition:
	mov		rdx, qword [rbp-1128]
	cmp		rdx, r12
	setl		al
	movzx	r8, al

	test	r8, r8
	jz		main_18_forMerge
	jmp		main_12_forBody

main_12_forBody:
	mov		r11, 0

	jmp		main_13_forCondition

main_13_forCondition:
	cmp		r11, r12
	setl		al
	movzx	r8, al

	test	r8, r8
	jz		main_16_forMerge
	jmp		main_14_forBody

main_14_forBody:
	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		r8, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r10, rax

	mov		rax, r8
	add		rax, r10
	mov		r10, rax

	mov		rax, qword [rbp-1128]
	add		rax, r11
	mov		r8, rax

	mov		[r10 + 0 * 8], r8

	mov		r8, [r10 + 0*8]

	jmp		main_15_forIncrease

main_15_forIncrease:
	mov		rcx, 1
	mov		rax, r11
	add		rax, rcx
	mov		r11, rax

	jmp		main_13_forCondition

main_16_forMerge:
	jmp		main_17_forIncrease

main_17_forIncrease:
	mov		rax, qword [rbp-1128]
	mov		rcx, 1
	add		rax, rcx
	mov		qword [rbp-1128], rax

	jmp		main_11_forCondition

main_18_forMerge:
	mov		rax, qword [rbp-1128]
	mov		rax, 0
	mov		qword [rbp-1128], rax

	jmp		main_19_forCondition

main_19_forCondition:
	mov		rdx, qword [rbp-1128]
	cmp		rdx, r12
	setl		al
	movzx	r8, al

	test	r8, r8
	jz		main_33_forMerge
	jmp		main_20_forBody

main_20_forBody:
	mov		r11, 0

	jmp		main_21_forCondition

main_21_forCondition:
	cmp		r11, r12
	setl		al
	movzx	r8, al

	test	r8, r8
	jz		main_31_forMerge
	jmp		main_22_forBody

main_22_forBody:
	mov		rax, qword [rbp-1008]
	mov		rax, 0
	mov		qword [rbp-1008], rax

	jmp		main_23_forCondition

main_23_forCondition:
	mov		rdx, qword [rbp-1008]
	cmp		rdx, r12
	setl		al
	movzx	r8, al

	test	r8, r8
	jz		main_29_forMerge
	jmp		main_24_forBody

main_24_forBody:
	mov		rax, qword [rbp-1128]
	cmp		r11, rax
	setge		al
	movzx	r8, al

	test	r8, r8
	jz		main_26_ifFalse
	jmp		main_25_ifTrue

main_25_ifTrue:
	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r15
	add		rax, r8
	mov		r8, rax

	mov		r10, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r10
	add		rax, r8
	mov		r13, rax

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r15
	add		rax, r8
	mov		r8, rax

	mov		r10, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r10
	add		rax, r8
	mov		r8, rax

	mov		rdx, qword [rbp-1232]
	mov		rdx, [r8 + 0*8]
	mov		qword [rbp-1232], rdx

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		r10, [r8 + 0*8]

	mov		rax, qword [rbp-1008]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r10
	add		rax, r8
	mov		r8, rax

	mov		r10, [r8 + 0*8]

	mov		rax, qword [rbp-1008]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		r14, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r14
	add		rax, r8
	mov		r8, rax

	mov		r8, [r8 + 0*8]

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	sub		rsp, 32
	mov		qword[rsp+16], r8
	mov		qword[rsp+8], r10
	mov		rax, qword [rbp-1232]
	mov		qword[rsp+0], rax
	call	func
	add		rsp, 32
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r8, rax

	mov		[r13 + 0 * 8], r8

	mov		r8, [r13 + 0*8]

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r9
	add		rax, r8
	mov		r8, rax

	mov		r8, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r10, rax

	mov		rax, r8
	add		rax, r10
	mov		r10, rax

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r15
	add		rax, r8
	mov		r8, rax

	mov		r13, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r13
	add		rax, r8
	mov		r8, rax

	mov		rdx, qword [rbp-208]
	mov		rdx, [r8 + 0*8]
	mov		qword [rbp-208], rdx

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		r13, [r8 + 0*8]

	mov		rax, qword [rbp-1008]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r13
	add		rax, r8
	mov		r8, rax

	mov		r14, [r8 + 0*8]

	mov		rax, qword [rbp-1008]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		r8, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r13, rax

	mov		rax, r8
	add		rax, r13
	mov		r8, rax

	mov		r8, [r8 + 0*8]

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	sub		rsp, 32
	mov		qword[rsp+16], r8
	mov		qword[rsp+8], r14
	mov		rax, qword [rbp-208]
	mov		qword[rsp+0], rax
	call	func
	add		rsp, 32
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r8, rax

	mov		[r10 + 0 * 8], r8

	mov		r8, [r10 + 0*8]

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r9
	add		rax, r8
	mov		r8, rax

	mov		r10, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r10
	add		rax, r8
	mov		r10, rax

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r15
	add		rax, r8
	mov		r8, rax

	mov		r13, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r13
	add		rax, r8
	mov		r8, rax

	mov		rdx, qword [rbp-168]
	mov		rdx, [r8 + 0*8]
	mov		qword [rbp-168], rdx

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		r13, [r8 + 0*8]

	mov		rax, qword [rbp-1008]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r13
	add		rax, r8
	mov		r8, rax

	mov		r14, [r8 + 0*8]

	mov		rax, qword [rbp-1008]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		r13, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r13
	add		rax, r8
	mov		r8, rax

	mov		r8, [r8 + 0*8]

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	sub		rsp, 32
	mov		qword[rsp+16], r8
	mov		qword[rsp+8], r14
	mov		rax, qword [rbp-168]
	mov		qword[rsp+0], rax
	call	func
	add		rsp, 32
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r8, rax

	mov		[r10 + 0 * 8], r8

	mov		r8, [r10 + 0*8]

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r9
	add		rax, r8
	mov		r8, rax

	mov		r10, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r10
	add		rax, r8
	mov		r10, rax

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r15
	add		rax, r8
	mov		r8, rax

	mov		r13, [r8 + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r13
	add		rax, r8
	mov		r8, rax

	mov		r14, [r8 + 0*8]

	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		r13, [r8 + 0*8]

	mov		rax, qword [rbp-1008]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, r13
	add		rax, r8
	mov		r8, rax

	mov		r13, [r8 + 0*8]

	mov		rax, qword [rbp-1008]
	mov		rcx, 8
	imul		rax, rcx
	mov		r8, rax

	mov		rax, rbx
	add		rax, r8
	mov		r8, rax

	mov		rdx, qword [rbp-648]
	mov		rdx, [r8 + 0*8]
	mov		qword [rbp-648], rdx

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r8, rax

	mov		rax, qword [rbp-648]
	add		rax, r8
	mov		r8, rax

	mov		r8, [r8 + 0*8]

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	sub		rsp, 32
	mov		qword[rsp+16], r8
	mov		qword[rsp+8], r13
	mov		qword[rsp+0], r14
	call	func
	add		rsp, 32
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		r8, rax

	mov		[r10 + 0 * 8], r8

	mov		r8, [r10 + 0*8]

	jmp		main_27_ifMerge

main_26_ifFalse:
	jmp		main_27_ifMerge

main_27_ifMerge:
	jmp		main_28_forIncrease

main_28_forIncrease:
	mov		rax, qword [rbp-1008]
	mov		rcx, 1
	add		rax, rcx
	mov		qword [rbp-1008], rax

	jmp		main_23_forCondition

main_29_forMerge:
	jmp		main_30_forIncrease

main_30_forIncrease:
	mov		rcx, 1
	mov		rax, r11
	add		rax, rcx
	mov		r11, rax

	jmp		main_21_forCondition

main_31_forMerge:
	jmp		main_32_forIncrease

main_32_forIncrease:
	mov		rax, qword [rbp-1128]
	mov		rcx, 1
	add		rax, rcx
	mov		qword [rbp-1128], rax

	jmp		main_19_forCondition

main_33_forMerge:
	mov		r8, 0

	mov		rax, qword [rbp-1128]
	mov		rax, 0
	mov		qword [rbp-1128], rax

	jmp		main_34_forCondition

main_34_forCondition:
	mov		rdx, qword [rbp-1128]
	cmp		rdx, r12
	setl		al
	movzx	rbx, al

	test	rbx, rbx
	jz		main_41_forMerge
	jmp		main_35_forBody

main_35_forBody:
	mov		r11, 0

	jmp		main_36_forCondition

main_36_forCondition:
	cmp		r11, r12
	setl		al
	movzx	rbx, al

	test	rbx, rbx
	jz		main_39_forMerge
	jmp		main_37_forBody

main_37_forBody:
	mov		rax, qword [rbp-1128]
	mov		rcx, 8
	imul		rax, rcx
	mov		rbx, rax

	mov		rax, r15
	add		rax, rbx
	mov		rbx, rax

	mov		rbx, [rbx + 0*8]

	mov		rcx, 8
	mov		rax, r11
	imul		rax, rcx
	mov		r9, rax

	mov		rax, rbx
	add		rax, r9
	mov		rbx, rax

	mov		rbx, [rbx + 0*8]

	mov		rax, r8
	add		rax, rbx
	mov		rbx, rax

	mov		rcx, 1073741823
	mov		rax, rbx
	and		rax, rcx
	mov		rbx, rax

	mov		r8, rbx

	jmp		main_38_forIncrease

main_38_forIncrease:
	mov		rcx, 1
	mov		rax, r11
	add		rax, rcx
	mov		r11, rax

	jmp		main_36_forCondition

main_39_forMerge:
	jmp		main_40_forIncrease

main_40_forIncrease:
	mov		rax, qword [rbp-1128]
	mov		rcx, 1
	add		rax, rcx
	mov		qword [rbp-1128], rax

	jmp		main_34_forCondition

main_41_forMerge:
	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	mov		rdi, r8
	call	FBH_toString
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]
	mov		rbx, rax

	mov		qword[rsp-96], r12
	mov		qword[rsp-80], r10
	mov		qword[rsp-64], r8
	mov		qword[rsp-112], r14
	sub		rsp, 128
	mov		rdi, rbx
	call	FBH_print
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		r10, qword[rsp-80]
	mov		r8, qword[rsp-64]
	mov		r14, qword[rsp-112]

	mov		rax, 0
	leave
	ret

	jmp		main_42_exit

main_42_exit:
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
@getIntBuf:
    resq                    1
@parseIntBuf:
    resq                    1

