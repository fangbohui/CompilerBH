	default rel

	global main

extern printf, malloc, strcpy, scanf, strlen, sscanf, sprintf, memcpy, strcmp, puts

	SECTION .text

main:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 624
	mov		qword[rsp-96], r12
	mov		qword[rsp-24], rbx
	mov		qword[rsp-120], r15
	mov		qword[rsp-104], r13
	mov		qword[rsp-112], r14
	sub		rsp, 128
main_0_beginning:
	mov		rax, 99
	mov		qword [global_var_h], rax

	mov		rax, 100
	mov		qword [global_var_i], rax

	mov		rax, 101
	mov		qword [global_var_j], rax

	mov		rax, 102
	mov		qword [global_var_k], rax

	mov		rax, 0
	mov		qword [global_var_total], rax

	jmp		main_1_entry

main_1_entry:
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	sub		rsp, 128
	call	FBH_getInt
	add		rsp, 128
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r12, rax

	mov		qword [global_var_N], r12

	mov		r14, 1

	jmp		main_2_forCondition

main_2_forCondition:
	mov		rax, qword [global_var_N]
	cmp		r14, rax
	setle		al
	movzx	r12, al

	test	r12, r12
	jz		main_148_forMerge
	jmp		main_3_forBody

main_3_forBody:
	mov		r13, 1

	jmp		main_4_forCondition

main_4_forCondition:
	mov		rax, qword [global_var_N]
	cmp		r13, rax
	setle		al
	movzx	r12, al

	test	r12, r12
	jz		main_146_forMerge
	jmp		main_5_forBody

main_5_forBody:
	mov		r9, 1

	jmp		main_6_forCondition

main_6_forCondition:
	mov		rax, qword [global_var_N]
	cmp		r9, rax
	setle		al
	movzx	r12, al

	test	r12, r12
	jz		main_144_forMerge
	jmp		main_7_forBody

main_7_forBody:
	mov		rbx, 1

	jmp		main_8_forCondition

main_8_forCondition:
	mov		rax, qword [global_var_N]
	cmp		rbx, rax
	setle		al
	movzx	r12, al

	test	r12, r12
	jz		main_142_forMerge
	jmp		main_9_forBody

main_9_forBody:
	mov		r15, 1

	jmp		main_10_forCondition

main_10_forCondition:
	mov		rax, qword [global_var_N]
	cmp		r15, rax
	setle		al
	movzx	r12, al

	test	r12, r12
	jz		main_140_forMerge
	jmp		main_11_forBody

main_11_forBody:
	mov		r8, 1

	jmp		main_12_forCondition

main_12_forCondition:
	mov		rax, qword [global_var_N]
	cmp		r8, rax
	setle		al
	movzx	r12, al

	test	r12, r12
	jz		main_138_forMerge
	jmp		main_13_forBody

main_13_forBody:
	cmp		r14, r13
	setne		al
	movzx	r12, al

	test	r12, r12
	jz		main_15_leftFalse
	jmp		main_14_leftTrue

main_14_leftTrue:
	cmp		r14, r9
	setne		al
	movzx	r12, al

	jmp		main_16_mergeBranch

main_15_leftFalse:
	mov		r12, 0

	jmp		main_16_mergeBranch

main_16_mergeBranch:
	test	r12, r12
	jz		main_18_leftFalse
	jmp		main_17_leftTrue

main_17_leftTrue:
	cmp		r14, rbx
	setne		al
	movzx	r12, al

	jmp		main_19_mergeBranch

main_18_leftFalse:
	mov		r12, 0

	jmp		main_19_mergeBranch

main_19_mergeBranch:
	test	r12, r12
	jz		main_21_leftFalse
	jmp		main_20_leftTrue

main_20_leftTrue:
	cmp		r14, r15
	setne		al
	movzx	r12, al

	jmp		main_22_mergeBranch

main_21_leftFalse:
	mov		r12, 0

	jmp		main_22_mergeBranch

main_22_mergeBranch:
	test	r12, r12
	jz		main_24_leftFalse
	jmp		main_23_leftTrue

main_23_leftTrue:
	cmp		r14, r8
	setne		al
	movzx	r12, al

	jmp		main_25_mergeBranch

main_24_leftFalse:
	mov		r12, 0

	jmp		main_25_mergeBranch

main_25_mergeBranch:
	test	r12, r12
	jz		main_27_leftFalse
	jmp		main_26_leftTrue

main_26_leftTrue:
	mov		rax, qword [global_var_h]
	cmp		r14, rax
	setne		al
	movzx	r12, al

	jmp		main_28_mergeBranch

main_27_leftFalse:
	mov		r12, 0

	jmp		main_28_mergeBranch

main_28_mergeBranch:
	test	r12, r12
	jz		main_30_leftFalse
	jmp		main_29_leftTrue

main_29_leftTrue:
	mov		rax, qword [global_var_i]
	cmp		r14, rax
	setne		al
	movzx	r12, al

	jmp		main_31_mergeBranch

main_30_leftFalse:
	mov		r12, 0

	jmp		main_31_mergeBranch

main_31_mergeBranch:
	test	r12, r12
	jz		main_33_leftFalse
	jmp		main_32_leftTrue

main_32_leftTrue:
	mov		rax, qword [global_var_j]
	cmp		r14, rax
	setne		al
	movzx	r12, al

	jmp		main_34_mergeBranch

main_33_leftFalse:
	mov		r12, 0

	jmp		main_34_mergeBranch

main_34_mergeBranch:
	test	r12, r12
	jz		main_36_leftFalse
	jmp		main_35_leftTrue

main_35_leftTrue:
	mov		rax, qword [global_var_k]
	cmp		r14, rax
	setne		al
	movzx	r12, al

	jmp		main_37_mergeBranch

main_36_leftFalse:
	mov		r12, 0

	jmp		main_37_mergeBranch

main_37_mergeBranch:
	test	r12, r12
	jz		main_39_leftFalse
	jmp		main_38_leftTrue

main_38_leftTrue:
	cmp		r13, r9
	setne		al
	movzx	r12, al

	jmp		main_40_mergeBranch

main_39_leftFalse:
	mov		r12, 0

	jmp		main_40_mergeBranch

main_40_mergeBranch:
	test	r12, r12
	jz		main_42_leftFalse
	jmp		main_41_leftTrue

main_41_leftTrue:
	cmp		r13, rbx
	setne		al
	movzx	r12, al

	jmp		main_43_mergeBranch

main_42_leftFalse:
	mov		r12, 0

	jmp		main_43_mergeBranch

main_43_mergeBranch:
	test	r12, r12
	jz		main_45_leftFalse
	jmp		main_44_leftTrue

main_44_leftTrue:
	cmp		r13, r15
	setne		al
	movzx	r12, al

	jmp		main_46_mergeBranch

main_45_leftFalse:
	mov		r12, 0

	jmp		main_46_mergeBranch

main_46_mergeBranch:
	test	r12, r12
	jz		main_48_leftFalse
	jmp		main_47_leftTrue

main_47_leftTrue:
	cmp		r13, r8
	setne		al
	movzx	r12, al

	jmp		main_49_mergeBranch

main_48_leftFalse:
	mov		r12, 0

	jmp		main_49_mergeBranch

main_49_mergeBranch:
	test	r12, r12
	jz		main_51_leftFalse
	jmp		main_50_leftTrue

main_50_leftTrue:
	mov		rax, qword [global_var_h]
	cmp		r13, rax
	setne		al
	movzx	r12, al

	jmp		main_52_mergeBranch

main_51_leftFalse:
	mov		r12, 0

	jmp		main_52_mergeBranch

main_52_mergeBranch:
	test	r12, r12
	jz		main_54_leftFalse
	jmp		main_53_leftTrue

main_53_leftTrue:
	mov		rax, qword [global_var_i]
	cmp		r13, rax
	setne		al
	movzx	r12, al

	jmp		main_55_mergeBranch

main_54_leftFalse:
	mov		r12, 0

	jmp		main_55_mergeBranch

main_55_mergeBranch:
	test	r12, r12
	jz		main_57_leftFalse
	jmp		main_56_leftTrue

main_56_leftTrue:
	mov		rax, qword [global_var_j]
	cmp		r13, rax
	setne		al
	movzx	r12, al

	jmp		main_58_mergeBranch

main_57_leftFalse:
	mov		r12, 0

	jmp		main_58_mergeBranch

main_58_mergeBranch:
	test	r12, r12
	jz		main_60_leftFalse
	jmp		main_59_leftTrue

main_59_leftTrue:
	mov		rax, qword [global_var_k]
	cmp		r13, rax
	setne		al
	movzx	r12, al

	jmp		main_61_mergeBranch

main_60_leftFalse:
	mov		r12, 0

	jmp		main_61_mergeBranch

main_61_mergeBranch:
	test	r12, r12
	jz		main_63_leftFalse
	jmp		main_62_leftTrue

main_62_leftTrue:
	cmp		r9, rbx
	setne		al
	movzx	r12, al

	jmp		main_64_mergeBranch

main_63_leftFalse:
	mov		r12, 0

	jmp		main_64_mergeBranch

main_64_mergeBranch:
	test	r12, r12
	jz		main_66_leftFalse
	jmp		main_65_leftTrue

main_65_leftTrue:
	cmp		r9, r15
	setne		al
	movzx	r12, al

	jmp		main_67_mergeBranch

main_66_leftFalse:
	mov		r12, 0

	jmp		main_67_mergeBranch

main_67_mergeBranch:
	test	r12, r12
	jz		main_69_leftFalse
	jmp		main_68_leftTrue

main_68_leftTrue:
	cmp		r9, r8
	setne		al
	movzx	r12, al

	jmp		main_70_mergeBranch

main_69_leftFalse:
	mov		r12, 0

	jmp		main_70_mergeBranch

main_70_mergeBranch:
	test	r12, r12
	jz		main_72_leftFalse
	jmp		main_71_leftTrue

main_71_leftTrue:
	mov		rax, qword [global_var_h]
	cmp		r9, rax
	setne		al
	movzx	r12, al

	jmp		main_73_mergeBranch

main_72_leftFalse:
	mov		r12, 0

	jmp		main_73_mergeBranch

main_73_mergeBranch:
	test	r12, r12
	jz		main_75_leftFalse
	jmp		main_74_leftTrue

main_74_leftTrue:
	mov		rax, qword [global_var_i]
	cmp		r9, rax
	setne		al
	movzx	r12, al

	jmp		main_76_mergeBranch

main_75_leftFalse:
	mov		r12, 0

	jmp		main_76_mergeBranch

main_76_mergeBranch:
	test	r12, r12
	jz		main_78_leftFalse
	jmp		main_77_leftTrue

main_77_leftTrue:
	mov		rax, qword [global_var_j]
	cmp		r9, rax
	setne		al
	movzx	r12, al

	jmp		main_79_mergeBranch

main_78_leftFalse:
	mov		r12, 0

	jmp		main_79_mergeBranch

main_79_mergeBranch:
	test	r12, r12
	jz		main_81_leftFalse
	jmp		main_80_leftTrue

main_80_leftTrue:
	mov		rax, qword [global_var_k]
	cmp		r9, rax
	setne		al
	movzx	r12, al

	jmp		main_82_mergeBranch

main_81_leftFalse:
	mov		r12, 0

	jmp		main_82_mergeBranch

main_82_mergeBranch:
	test	r12, r12
	jz		main_84_leftFalse
	jmp		main_83_leftTrue

main_83_leftTrue:
	cmp		rbx, r15
	setne		al
	movzx	r12, al

	jmp		main_85_mergeBranch

main_84_leftFalse:
	mov		r12, 0

	jmp		main_85_mergeBranch

main_85_mergeBranch:
	test	r12, r12
	jz		main_87_leftFalse
	jmp		main_86_leftTrue

main_86_leftTrue:
	cmp		rbx, r8
	setne		al
	movzx	r12, al

	jmp		main_88_mergeBranch

main_87_leftFalse:
	mov		r12, 0

	jmp		main_88_mergeBranch

main_88_mergeBranch:
	test	r12, r12
	jz		main_90_leftFalse
	jmp		main_89_leftTrue

main_89_leftTrue:
	mov		rax, qword [global_var_h]
	cmp		rbx, rax
	setne		al
	movzx	r12, al

	jmp		main_91_mergeBranch

main_90_leftFalse:
	mov		r12, 0

	jmp		main_91_mergeBranch

main_91_mergeBranch:
	test	r12, r12
	jz		main_93_leftFalse
	jmp		main_92_leftTrue

main_92_leftTrue:
	mov		rax, qword [global_var_i]
	cmp		rbx, rax
	setne		al
	movzx	r12, al

	jmp		main_94_mergeBranch

main_93_leftFalse:
	mov		r12, 0

	jmp		main_94_mergeBranch

main_94_mergeBranch:
	test	r12, r12
	jz		main_96_leftFalse
	jmp		main_95_leftTrue

main_95_leftTrue:
	mov		rax, qword [global_var_j]
	cmp		rbx, rax
	setne		al
	movzx	r12, al

	jmp		main_97_mergeBranch

main_96_leftFalse:
	mov		r12, 0

	jmp		main_97_mergeBranch

main_97_mergeBranch:
	test	r12, r12
	jz		main_99_leftFalse
	jmp		main_98_leftTrue

main_98_leftTrue:
	mov		rax, qword [global_var_k]
	cmp		rbx, rax
	setne		al
	movzx	r12, al

	jmp		main_100_mergeBranch

main_99_leftFalse:
	mov		r12, 0

	jmp		main_100_mergeBranch

main_100_mergeBranch:
	test	r12, r12
	jz		main_102_leftFalse
	jmp		main_101_leftTrue

main_101_leftTrue:
	cmp		r15, r8
	setne		al
	movzx	r12, al

	jmp		main_103_mergeBranch

main_102_leftFalse:
	mov		r12, 0

	jmp		main_103_mergeBranch

main_103_mergeBranch:
	test	r12, r12
	jz		main_105_leftFalse
	jmp		main_104_leftTrue

main_104_leftTrue:
	mov		rax, qword [global_var_h]
	cmp		r15, rax
	setne		al
	movzx	r12, al

	jmp		main_106_mergeBranch

main_105_leftFalse:
	mov		r12, 0

	jmp		main_106_mergeBranch

main_106_mergeBranch:
	test	r12, r12
	jz		main_108_leftFalse
	jmp		main_107_leftTrue

main_107_leftTrue:
	mov		rax, qword [global_var_i]
	cmp		r15, rax
	setne		al
	movzx	r12, al

	jmp		main_109_mergeBranch

main_108_leftFalse:
	mov		r12, 0

	jmp		main_109_mergeBranch

main_109_mergeBranch:
	test	r12, r12
	jz		main_111_leftFalse
	jmp		main_110_leftTrue

main_110_leftTrue:
	mov		rax, qword [global_var_j]
	cmp		r15, rax
	setne		al
	movzx	r12, al

	jmp		main_112_mergeBranch

main_111_leftFalse:
	mov		r12, 0

	jmp		main_112_mergeBranch

main_112_mergeBranch:
	test	r12, r12
	jz		main_114_leftFalse
	jmp		main_113_leftTrue

main_113_leftTrue:
	mov		rax, qword [global_var_k]
	cmp		r15, rax
	setne		al
	movzx	r12, al

	jmp		main_115_mergeBranch

main_114_leftFalse:
	mov		r12, 0

	jmp		main_115_mergeBranch

main_115_mergeBranch:
	test	r12, r12
	jz		main_117_leftFalse
	jmp		main_116_leftTrue

main_116_leftTrue:
	mov		rax, qword [global_var_h]
	cmp		r8, rax
	setne		al
	movzx	r12, al

	jmp		main_118_mergeBranch

main_117_leftFalse:
	mov		r12, 0

	jmp		main_118_mergeBranch

main_118_mergeBranch:
	test	r12, r12
	jz		main_120_leftFalse
	jmp		main_119_leftTrue

main_119_leftTrue:
	mov		rax, qword [global_var_i]
	cmp		r8, rax
	setne		al
	movzx	r12, al

	jmp		main_121_mergeBranch

main_120_leftFalse:
	mov		r12, 0

	jmp		main_121_mergeBranch

main_121_mergeBranch:
	test	r12, r12
	jz		main_123_leftFalse
	jmp		main_122_leftTrue

main_122_leftTrue:
	mov		rax, qword [global_var_j]
	cmp		r8, rax
	setne		al
	movzx	r12, al

	jmp		main_124_mergeBranch

main_123_leftFalse:
	mov		r12, 0

	jmp		main_124_mergeBranch

main_124_mergeBranch:
	test	r12, r12
	jz		main_126_leftFalse
	jmp		main_125_leftTrue

main_125_leftTrue:
	mov		rax, qword [global_var_k]
	cmp		r8, rax
	setne		al
	movzx	r12, al

	jmp		main_127_mergeBranch

main_126_leftFalse:
	mov		r12, 0

	jmp		main_127_mergeBranch

main_127_mergeBranch:
	test	r12, r12
	jz		main_129_leftFalse
	jmp		main_128_leftTrue

main_128_leftTrue:
	mov		rdx, qword [global_var_i]
	mov		rax, qword [global_var_j]
	cmp		rdx, rax
	setne		al
	movzx	r12, al

	jmp		main_130_mergeBranch

main_129_leftFalse:
	mov		r12, 0

	jmp		main_130_mergeBranch

main_130_mergeBranch:
	test	r12, r12
	jz		main_132_leftFalse
	jmp		main_131_leftTrue

main_131_leftTrue:
	mov		rdx, qword [global_var_h]
	mov		rax, qword [global_var_k]
	cmp		rdx, rax
	setne		al
	movzx	r12, al

	jmp		main_133_mergeBranch

main_132_leftFalse:
	mov		r12, 0

	jmp		main_133_mergeBranch

main_133_mergeBranch:
	test	r12, r12
	jz		main_135_ifFalse
	jmp		main_134_ifTrue

main_134_ifTrue:
	mov		rax, qword [global_var_total]
	mov		r12, rax

	mov		rax, qword [global_var_total]
	mov		rcx, 1
	lea		rdx, [rax + rcx]
	mov		qword [global_var_total], rdx

	jmp		main_136_ifMerge

main_135_ifFalse:
	jmp		main_136_ifMerge

main_136_ifMerge:
	jmp		main_137_forIncrease

main_137_forIncrease:
	mov		r12, r8

	mov		rcx, 1
	lea		r8, [r8 + rcx]

	jmp		main_12_forCondition

main_138_forMerge:
	jmp		main_139_forIncrease

main_139_forIncrease:
	mov		r12, r15

	mov		rcx, 1
	lea		r15, [r15 + rcx]

	jmp		main_10_forCondition

main_140_forMerge:
	jmp		main_141_forIncrease

main_141_forIncrease:
	mov		r12, rbx

	mov		rcx, 1
	lea		rbx, [rbx + rcx]

	jmp		main_8_forCondition

main_142_forMerge:
	jmp		main_143_forIncrease

main_143_forIncrease:
	mov		r12, r9

	mov		rcx, 1
	lea		r9, [r9 + rcx]

	jmp		main_6_forCondition

main_144_forMerge:
	jmp		main_145_forIncrease

main_145_forIncrease:
	mov		r12, r13

	mov		rcx, 1
	lea		r13, [r13 + rcx]

	jmp		main_4_forCondition

main_146_forMerge:
	jmp		main_147_forIncrease

main_147_forIncrease:
	mov		r12, r14

	mov		rcx, 1
	lea		r14, [r14 + rcx]

	jmp		main_2_forCondition

main_148_forMerge:
	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	sub		rsp, 128
	mov		rdi, qword [global_var_total]
	call	FBH_toString
	add		rsp, 128
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]
	mov		r12, rax

	mov		qword[rsp-64], r8
	mov		qword[rsp-72], r9
	sub		rsp, 128
	mov		rdi, r12
	call	FBH_println
	add		rsp, 128
	mov		r8, qword[rsp-64]
	mov		r9, qword[rsp-72]

	mov		rax, 0
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		rbx, qword[rsp-24]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
	leave
	ret

	jmp		main_149_exit

main_149_exit:
	add		rsp, 128
	mov		r12, qword[rsp-96]
	mov		rbx, qword[rsp-24]
	mov		r15, qword[rsp-120]
	mov		r13, qword[rsp-104]
	mov		r14, qword[rsp-112]
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
global_var_N:
    resq                    1
global_var_h:
    resq                    1
global_var_i:
    resq                    1
global_var_j:
    resq                    1
global_var_k:
    resq                    1
global_var_total:
    resq                    1
@getIntBuf:
    resq                    1
@parseIntBuf:
    resq                    1

