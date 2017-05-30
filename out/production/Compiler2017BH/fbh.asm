	default rel

	global func
	global main

extern printf, malloc, strcpy, scanf, strlen, sscanf, sprintf, memcpy, strcmp, puts

	SECTION .text

func:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 176
	mov		qword[rsp-96], r12
	sub		rsp, 128
func_0_beginning:
	jmp		func_1_entry

func_1_entry:
	mov		rax, qword [rbp+16]
	mov		rcx, qword [rbp+24]
	mov		r12, rax
	add		r12, rcx

	mov		rcx, qword [rbp+32]
	add		r12, rcx

	mov		rcx, 1073741823
	and		r12, rcx

	mov		rax, r12
	add		rsp, 128
	mov		r12, qword[rsp-96]
	leave
	ret

	jmp		func_2_exit

func_2_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	leave
	ret


main:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 1360
	mov		qword[rsp-120], r15
	mov		qword[rsp-24], rbx
	mov		qword[rsp-96], r12
	mov		qword[rsp-112], r14
	mov		qword[rsp-104], r13
	sub		rsp, 128
main_0_beginning:
	jmp		main_1_entry

main_1_entry:
	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	call	FBH_getInt
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r12, rax

	mov		r8, r12

	mov		rcx, 8
	mov		r12, r8
	imul		r12, rcx

	mov		rcx, 8
	add		r12, rcx

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	mov		rdi, r12
	call	malloc
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r15, rax

	mov		rcx, 8
	sub		r12, rcx

	mov		[r15 + 0 * 8], r8

	mov		rcx, 8
	add		r15, rcx

	mov		r13, r15

	mov		r14, r15
	add		r14, r12

	jmp		main_2_whileCondition

main_2_whileCondition:
	cmp		r15, r14
	setne		al
	movzx	r12, al

	test	r12, r12
	jz		main_4_whileMerge
	jmp		main_3_whileBody

main_3_whileBody:
	mov		rcx, 8
	mov		rbx, r8
	imul		rbx, rcx

	mov		rcx, 8
	add		rbx, rcx

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	mov		rdi, rbx
	call	malloc
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r12, rax

	mov		rcx, 8
	sub		rbx, rcx

	mov		[r12 + 0 * 8], r8

	mov		rcx, 8
	add		r12, rcx

	mov		[r15 + 0 * 8], r12

	mov		rcx, 8
	add		r15, rcx

	jmp		main_2_whileCondition

main_4_whileMerge:
	mov		qword [rbp-1144], r13

	mov		rcx, 8
	mov		r12, r8
	imul		r12, rcx

	mov		rcx, 8
	add		r12, rcx

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	mov		rdi, r12
	call	malloc
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r13, rax

	mov		rcx, 8
	sub		r12, rcx

	mov		[r13 + 0 * 8], r8

	mov		rcx, 8
	add		r13, rcx

	mov		rbx, r13

	mov		r15, r13
	add		r15, r12

	jmp		main_5_whileCondition

main_5_whileCondition:
	cmp		r13, r15
	setne		al
	movzx	r12, al

	test	r12, r12
	jz		main_7_whileMerge
	jmp		main_6_whileBody

main_6_whileBody:
	mov		rcx, 8
	mov		r14, r8
	imul		r14, rcx

	mov		rcx, 8
	add		r14, rcx

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	mov		rdi, r14
	call	malloc
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r12, rax

	mov		rcx, 8
	sub		r14, rcx

	mov		[r12 + 0 * 8], r8

	mov		rcx, 8
	add		r12, rcx

	mov		[r13 + 0 * 8], r12

	mov		rcx, 8
	add		r13, rcx

	jmp		main_5_whileCondition

main_7_whileMerge:
	mov		r13, rbx

	mov		rcx, 8
	mov		r12, r8
	imul		r12, rcx

	mov		rcx, 8
	add		r12, rcx

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	mov		rdi, r12
	call	malloc
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r14, rax

	mov		rcx, 8
	sub		r12, rcx

	mov		[r14 + 0 * 8], r8

	mov		rcx, 8
	add		r14, rcx

	mov		rbx, r14

	mov		r9, r14
	add		r9, r12

	jmp		main_8_whileCondition

main_8_whileCondition:
	cmp		r14, r9
	setne		al
	movzx	r12, al

	test	r12, r12
	jz		main_10_whileMerge
	jmp		main_9_whileBody

main_9_whileBody:
	mov		rcx, 8
	mov		r15, r8
	imul		r15, rcx

	mov		rcx, 8
	add		r15, rcx

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	mov		rdi, r15
	call	malloc
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r12, rax

	mov		rcx, 8
	sub		r15, rcx

	mov		[r12 + 0 * 8], r8

	mov		rcx, 8
	add		r12, rcx

	mov		[r14 + 0 * 8], r12

	mov		rcx, 8
	add		r14, rcx

	jmp		main_8_whileCondition

main_10_whileMerge:
	mov		r11, rbx

	mov		r9, 0

	jmp		main_11_forCondition

main_11_forCondition:
	cmp		r9, r8
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		main_18_forMerge
	jmp		main_12_forBody

main_12_forBody:
	mov		r14, 0

	jmp		main_13_forCondition

main_13_forCondition:
	cmp		r14, r8
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		main_16_forMerge
	jmp		main_14_forBody

main_14_forBody:
	mov		rcx, 8
	mov		r15, r9
	imul		r15, rcx

	mov		rax, qword [rbp-1144]
	mov		r12, rax
	add		r12, r15

	mov		r15, [r12 + 0*8]

	mov		rcx, 8
	mov		r12, r14
	imul		r12, rcx

	add		r15, r12

	mov		r12, r9
	add		r12, r14

	mov		[r15 + 0 * 8], r12

	mov		r12, [r15 + 0*8]

	jmp		main_15_forIncrease

main_15_forIncrease:
	mov		rcx, 1
	add		r14, rcx

	jmp		main_13_forCondition

main_16_forMerge:
	jmp		main_17_forIncrease

main_17_forIncrease:
	mov		rcx, 1
	add		r9, rcx

	jmp		main_11_forCondition

main_18_forMerge:
	mov		r9, 0

	jmp		main_19_forCondition

main_19_forCondition:
	cmp		r9, r8
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		main_33_forMerge
	jmp		main_20_forBody

main_20_forBody:
	mov		r14, 0

	jmp		main_21_forCondition

main_21_forCondition:
	cmp		r14, r8
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		main_31_forMerge
	jmp		main_22_forBody

main_22_forBody:
	mov		r10, 0

	jmp		main_23_forCondition

main_23_forCondition:
	cmp		r10, r8
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		main_29_forMerge
	jmp		main_24_forBody

main_24_forBody:
	cmp		r14, r9
	setge		al
	movzx	r12, al

	test	r12, r12
	jz		main_26_ifFalse
	jmp		main_25_ifTrue

main_25_ifTrue:
	mov		rcx, 8
	mov		r15, r9
	imul		r15, rcx

	mov		r12, r13
	add		r12, r15

	mov		r15, [r12 + 0*8]

	mov		rcx, 8
	mov		r12, r14
	imul		r12, rcx

	add		r15, r12

	mov		rcx, 8
	mov		rbx, r9
	imul		rbx, rcx

	mov		r12, r13
	add		r12, rbx

	mov		r12, [r12 + 0*8]

	mov		rcx, 8
	mov		rbx, r14
	imul		rbx, rcx

	add		r12, rbx

	mov		rdx, qword [rbp-552]
	mov		rdx, [r12 + 0*8]
	mov		qword [rbp-552], rdx

	mov		rcx, 8
	mov		rbx, r9
	imul		rbx, rcx

	mov		rax, qword [rbp-1144]
	mov		r12, rax
	add		r12, rbx

	mov		r12, [r12 + 0*8]

	mov		rcx, 8
	mov		rbx, r10
	imul		rbx, rcx

	add		r12, rbx

	mov		rdx, qword [rbp-368]
	mov		rdx, [r12 + 0*8]
	mov		qword [rbp-368], rdx

	mov		rcx, 8
	mov		rbx, r10
	imul		rbx, rcx

	mov		rax, qword [rbp-1144]
	mov		r12, rax
	add		r12, rbx

	mov		r12, [r12 + 0*8]

	mov		rcx, 8
	mov		rbx, r14
	imul		rbx, rcx

	add		r12, rbx

	mov		r12, [r12 + 0*8]

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	sub		rsp, 32
	mov		qword[rsp+16], r12
	mov		rax, qword [rbp-368]
	mov		qword[rsp+8], rax
	mov		rax, qword [rbp-552]
	mov		qword[rsp+0], rax
	call	func
	add		rsp, 32
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r12, rax

	mov		[r15 + 0 * 8], r12

	mov		r12, [r15 + 0*8]

	mov		rcx, 8
	mov		r12, r9
	imul		r12, rcx

	mov		r15, r11
	add		r15, r12

	mov		r12, [r15 + 0*8]

	mov		rcx, 8
	mov		r15, r14
	imul		r15, rcx

	mov		rdx, qword [rbp-1216]
	mov		rdx, r12
	add		rdx, r15
	mov		qword [rbp-1216], rdx

	mov		rcx, 8
	mov		r12, r9
	imul		r12, rcx

	mov		r15, r13
	add		r15, r12

	mov		r12, [r15 + 0*8]

	mov		rcx, 8
	mov		r15, r14
	imul		r15, rcx

	add		r12, r15

	mov		r12, [r12 + 0*8]

	mov		rcx, 8
	mov		rbx, r9
	imul		rbx, rcx

	mov		rax, qword [rbp-1144]
	mov		r15, rax
	add		r15, rbx

	mov		r15, [r15 + 0*8]

	mov		rcx, 8
	mov		rbx, r10
	imul		rbx, rcx

	add		r15, rbx

	mov		rbx, [r15 + 0*8]

	mov		rcx, 8
	mov		rdx, qword [rbp-744]
	mov		rdx, r10
	imul		rdx, rcx
	mov		qword [rbp-744], rdx

	mov		rax, qword [rbp-1144]
	mov		rcx, qword [rbp-744]
	mov		r15, rax
	add		r15, rcx

	mov		r15, [r15 + 0*8]

	mov		rcx, 8
	mov		rdx, qword [rbp-792]
	mov		rdx, r14
	imul		rdx, rcx
	mov		qword [rbp-792], rdx

	mov		rcx, qword [rbp-792]
	add		r15, rcx

	mov		r15, [r15 + 0*8]

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	sub		rsp, 32
	mov		qword[rsp+16], r15
	mov		qword[rsp+8], rbx
	mov		qword[rsp+0], r12
	call	func
	add		rsp, 32
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r12, rax

	mov		rax, qword [rbp-1216]
	mov		[rax + 0 * 8], r12

	mov		rax, qword [rbp-1216]
	mov		r12, [rax + 0*8]

	mov		rcx, 8
	mov		r15, r9
	imul		r15, rcx

	mov		r12, r11
	add		r12, r15

	mov		r15, [r12 + 0*8]

	mov		rcx, 8
	mov		r12, r14
	imul		r12, rcx

	add		r15, r12

	mov		rcx, 8
	mov		r12, r9
	imul		r12, rcx

	mov		rbx, r13
	add		rbx, r12

	mov		r12, [rbx + 0*8]

	mov		rcx, 8
	mov		rbx, r14
	imul		rbx, rcx

	add		r12, rbx

	mov		rdx, qword [rbp-280]
	mov		rdx, [r12 + 0*8]
	mov		qword [rbp-280], rdx

	mov		rcx, 8
	mov		r12, r9
	imul		r12, rcx

	mov		rax, qword [rbp-1144]
	mov		rbx, rax
	add		rbx, r12

	mov		rbx, [rbx + 0*8]

	mov		rcx, 8
	mov		r12, r10
	imul		r12, rcx

	add		rbx, r12

	mov		rbx, [rbx + 0*8]

	mov		rcx, 8
	mov		r12, r10
	imul		r12, rcx

	mov		rax, qword [rbp-1144]
	mov		rdx, qword [rbp-1136]
	mov		rdx, rax
	add		rdx, r12
	mov		qword [rbp-1136], rdx

	mov		rax, qword [rbp-1136]
	mov		r12, [rax + 0*8]

	mov		rcx, 8
	mov		rdx, qword [rbp-232]
	mov		rdx, r14
	imul		rdx, rcx
	mov		qword [rbp-232], rdx

	mov		rcx, qword [rbp-232]
	add		r12, rcx

	mov		r12, [r12 + 0*8]

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	sub		rsp, 32
	mov		qword[rsp+16], r12
	mov		qword[rsp+8], rbx
	mov		rax, qword [rbp-280]
	mov		qword[rsp+0], rax
	call	func
	add		rsp, 32
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r12, rax

	mov		[r15 + 0 * 8], r12

	mov		r12, [r15 + 0*8]

	mov		rcx, 8
	mov		r15, r9
	imul		r15, rcx

	mov		r12, r11
	add		r12, r15

	mov		r12, [r12 + 0*8]

	mov		rcx, 8
	mov		r15, r14
	imul		r15, rcx

	add		r12, r15

	mov		rcx, 8
	mov		rbx, r9
	imul		rbx, rcx

	mov		r15, r13
	add		r15, rbx

	mov		r15, [r15 + 0*8]

	mov		rcx, 8
	mov		rbx, r14
	imul		rbx, rcx

	add		r15, rbx

	mov		rbx, [r15 + 0*8]

	mov		rcx, 8
	mov		r15, r9
	imul		r15, rcx

	mov		rax, qword [rbp-1144]
	mov		rdx, qword [rbp-448]
	mov		rdx, rax
	add		rdx, r15
	mov		qword [rbp-448], rdx

	mov		rax, qword [rbp-448]
	mov		r15, [rax + 0*8]

	mov		rcx, 8
	mov		rdx, qword [rbp-784]
	mov		rdx, r10
	imul		rdx, rcx
	mov		qword [rbp-784], rdx

	mov		rcx, qword [rbp-784]
	add		r15, rcx

	mov		rdx, qword [rbp-600]
	mov		rdx, [r15 + 0*8]
	mov		qword [rbp-600], rdx

	mov		rcx, 8
	mov		rdx, qword [rbp-272]
	mov		rdx, r10
	imul		rdx, rcx
	mov		qword [rbp-272], rdx

	mov		rax, qword [rbp-1144]
	mov		rcx, qword [rbp-272]
	mov		r15, rax
	add		r15, rcx

	mov		r15, [r15 + 0*8]

	mov		rcx, 8
	mov		rdx, qword [rbp-704]
	mov		rdx, r14
	imul		rdx, rcx
	mov		qword [rbp-704], rdx

	mov		rcx, qword [rbp-704]
	add		r15, rcx

	mov		r15, [r15 + 0*8]

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	sub		rsp, 32
	mov		qword[rsp+16], r15
	mov		rax, qword [rbp-600]
	mov		qword[rsp+8], rax
	mov		qword[rsp+0], rbx
	call	func
	add		rsp, 32
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r15, rax

	mov		[r12 + 0 * 8], r15

	mov		r12, [r12 + 0*8]

	jmp		main_27_ifMerge

main_26_ifFalse:
	jmp		main_27_ifMerge

main_27_ifMerge:
	jmp		main_28_forIncrease

main_28_forIncrease:
	mov		rcx, 1
	add		r10, rcx

	jmp		main_23_forCondition

main_29_forMerge:
	jmp		main_30_forIncrease

main_30_forIncrease:
	mov		rcx, 1
	add		r14, rcx

	jmp		main_21_forCondition

main_31_forMerge:
	jmp		main_32_forIncrease

main_32_forIncrease:
	mov		rcx, 1
	add		r9, rcx

	jmp		main_19_forCondition

main_33_forMerge:
	mov		r15, 0

	mov		r9, 0

	jmp		main_34_forCondition

main_34_forCondition:
	cmp		r9, r8
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		main_41_forMerge
	jmp		main_35_forBody

main_35_forBody:
	mov		r14, 0

	jmp		main_36_forCondition

main_36_forCondition:
	cmp		r14, r8
	setl		al
	movzx	r12, al

	test	r12, r12
	jz		main_39_forMerge
	jmp		main_37_forBody

main_37_forBody:
	mov		rcx, 8
	mov		r12, r9
	imul		r12, rcx

	mov		rbx, r13
	add		rbx, r12

	mov		rbx, [rbx + 0*8]

	mov		rcx, 8
	mov		r12, r14
	imul		r12, rcx

	add		rbx, r12

	mov		rbx, [rbx + 0*8]

	mov		r12, r15
	add		r12, rbx

	mov		rcx, 1073741823
	and		r12, rcx

	mov		r15, r12

	jmp		main_38_forIncrease

main_38_forIncrease:
	mov		rcx, 1
	add		r14, rcx

	jmp		main_36_forCondition

main_39_forMerge:
	jmp		main_40_forIncrease

main_40_forIncrease:
	mov		rcx, 1
	add		r9, rcx

	jmp		main_34_forCondition

main_41_forMerge:
	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	mov		rdi, r15
	call	FBH_toString
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]
	mov		r12, rax

	mov		qword[rsp-88], r11
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	mov		qword[rsp-80], r10
	sub		rsp, 128
	mov		rdi, r12
	call	FBH_print
	add		rsp, 128
	mov		r11, qword[rsp-88]
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r10, qword[rsp-80]

	mov		rax, 0
	add		rsp, 128
	mov		r15, qword[rsp-120]
	mov		rbx, qword[rsp-24]
	mov		r12, qword[rsp-96]
	mov		r14, qword[rsp-112]
	mov		r13, qword[rsp-104]
	leave
	ret

	jmp		main_42_exit

main_42_exit:
	add		rsp, 128
	mov		r15, qword[rsp-120]
	mov		rbx, qword[rsp-24]
	mov		r12, qword[rsp-96]
	mov		r14, qword[rsp-112]
	mov		r13, qword[rsp-104]
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

