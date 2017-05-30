	default rel

	global main

extern printf, malloc, strcpy, scanf, strlen, sscanf, sprintf, memcpy, strcmp, puts

	SECTION .text

main:
	push	rbp
	mov		rbp, rsp
	sub		rsp, 624
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
	call	FBH_getInt
	mov		qword [rbp-72], rax

	mov		rax, qword [rbp-72]
	mov		qword [global_var_N], rax

	mov		rax, 1
	mov		qword [rbp-16], rax

	jmp		main_2_forCondition

main_2_forCondition:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [global_var_N]
	cmp		rdx, rax
	setle		al
	movzx	eax, al
	mov		qword [rbp-136], rax

	mov		rax, qword [rbp-136]
	test	rax, rax
	jz		main_148_forMerge
	jmp		main_3_forBody

main_3_forBody:
	mov		rax, 1
	mov		qword [rbp-160], rax

	jmp		main_4_forCondition

main_4_forCondition:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [global_var_N]
	cmp		rdx, rax
	setle		al
	movzx	eax, al
	mov		qword [rbp-480], rax

	mov		rax, qword [rbp-480]
	test	rax, rax
	jz		main_146_forMerge
	jmp		main_5_forBody

main_5_forBody:
	mov		rax, 1
	mov		qword [rbp-184], rax

	jmp		main_6_forCondition

main_6_forCondition:
	mov		rdx, qword [rbp-184]
	mov		rax, qword [global_var_N]
	cmp		rdx, rax
	setle		al
	movzx	eax, al
	mov		qword [rbp-8], rax

	mov		rax, qword [rbp-8]
	test	rax, rax
	jz		main_144_forMerge
	jmp		main_7_forBody

main_7_forBody:
	mov		rax, 1
	mov		qword [rbp-224], rax

	jmp		main_8_forCondition

main_8_forCondition:
	mov		rdx, qword [rbp-224]
	mov		rax, qword [global_var_N]
	cmp		rdx, rax
	setle		al
	movzx	eax, al
	mov		qword [rbp-296], rax

	mov		rax, qword [rbp-296]
	test	rax, rax
	jz		main_142_forMerge
	jmp		main_9_forBody

main_9_forBody:
	mov		rax, 1
	mov		qword [rbp-56], rax

	jmp		main_10_forCondition

main_10_forCondition:
	mov		rdx, qword [rbp-56]
	mov		rax, qword [global_var_N]
	cmp		rdx, rax
	setle		al
	movzx	eax, al
	mov		qword [rbp-144], rax

	mov		rax, qword [rbp-144]
	test	rax, rax
	jz		main_140_forMerge
	jmp		main_11_forBody

main_11_forBody:
	mov		rax, 1
	mov		qword [rbp-176], rax

	jmp		main_12_forCondition

main_12_forCondition:
	mov		rdx, qword [rbp-176]
	mov		rax, qword [global_var_N]
	cmp		rdx, rax
	setle		al
	movzx	eax, al
	mov		qword [rbp-376], rax

	mov		rax, qword [rbp-376]
	test	rax, rax
	jz		main_138_forMerge
	jmp		main_13_forBody

main_13_forBody:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [rbp-160]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-448], rax

	mov		rax, qword [rbp-448]
	test	rax, rax
	jz		main_15_leftFalse
	jmp		main_14_leftTrue

main_14_leftTrue:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [rbp-184]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-360], rax

	jmp		main_16_mergeBranch

main_15_leftFalse:
	mov		rax, 0
	mov		qword [rbp-360], rax

	jmp		main_16_mergeBranch

main_16_mergeBranch:
	mov		rax, qword [rbp-360]
	test	rax, rax
	jz		main_18_leftFalse
	jmp		main_17_leftTrue

main_17_leftTrue:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [rbp-224]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-192], rax

	jmp		main_19_mergeBranch

main_18_leftFalse:
	mov		rax, 0
	mov		qword [rbp-192], rax

	jmp		main_19_mergeBranch

main_19_mergeBranch:
	mov		rax, qword [rbp-192]
	test	rax, rax
	jz		main_21_leftFalse
	jmp		main_20_leftTrue

main_20_leftTrue:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [rbp-56]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-96], rax

	jmp		main_22_mergeBranch

main_21_leftFalse:
	mov		rax, 0
	mov		qword [rbp-96], rax

	jmp		main_22_mergeBranch

main_22_mergeBranch:
	mov		rax, qword [rbp-96]
	test	rax, rax
	jz		main_24_leftFalse
	jmp		main_23_leftTrue

main_23_leftTrue:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [rbp-176]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-456], rax

	jmp		main_25_mergeBranch

main_24_leftFalse:
	mov		rax, 0
	mov		qword [rbp-456], rax

	jmp		main_25_mergeBranch

main_25_mergeBranch:
	mov		rax, qword [rbp-456]
	test	rax, rax
	jz		main_27_leftFalse
	jmp		main_26_leftTrue

main_26_leftTrue:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [global_var_h]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-392], rax

	jmp		main_28_mergeBranch

main_27_leftFalse:
	mov		rax, 0
	mov		qword [rbp-392], rax

	jmp		main_28_mergeBranch

main_28_mergeBranch:
	mov		rax, qword [rbp-392]
	test	rax, rax
	jz		main_30_leftFalse
	jmp		main_29_leftTrue

main_29_leftTrue:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [global_var_i]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-256], rax

	jmp		main_31_mergeBranch

main_30_leftFalse:
	mov		rax, 0
	mov		qword [rbp-256], rax

	jmp		main_31_mergeBranch

main_31_mergeBranch:
	mov		rax, qword [rbp-256]
	test	rax, rax
	jz		main_33_leftFalse
	jmp		main_32_leftTrue

main_32_leftTrue:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [global_var_j]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-416], rax

	jmp		main_34_mergeBranch

main_33_leftFalse:
	mov		rax, 0
	mov		qword [rbp-416], rax

	jmp		main_34_mergeBranch

main_34_mergeBranch:
	mov		rax, qword [rbp-416]
	test	rax, rax
	jz		main_36_leftFalse
	jmp		main_35_leftTrue

main_35_leftTrue:
	mov		rdx, qword [rbp-16]
	mov		rax, qword [global_var_k]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-496], rax

	jmp		main_37_mergeBranch

main_36_leftFalse:
	mov		rax, 0
	mov		qword [rbp-496], rax

	jmp		main_37_mergeBranch

main_37_mergeBranch:
	mov		rax, qword [rbp-496]
	test	rax, rax
	jz		main_39_leftFalse
	jmp		main_38_leftTrue

main_38_leftTrue:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [rbp-184]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-472], rax

	jmp		main_40_mergeBranch

main_39_leftFalse:
	mov		rax, 0
	mov		qword [rbp-472], rax

	jmp		main_40_mergeBranch

main_40_mergeBranch:
	mov		rax, qword [rbp-472]
	test	rax, rax
	jz		main_42_leftFalse
	jmp		main_41_leftTrue

main_41_leftTrue:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [rbp-224]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-384], rax

	jmp		main_43_mergeBranch

main_42_leftFalse:
	mov		rax, 0
	mov		qword [rbp-384], rax

	jmp		main_43_mergeBranch

main_43_mergeBranch:
	mov		rax, qword [rbp-384]
	test	rax, rax
	jz		main_45_leftFalse
	jmp		main_44_leftTrue

main_44_leftTrue:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [rbp-56]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-120], rax

	jmp		main_46_mergeBranch

main_45_leftFalse:
	mov		rax, 0
	mov		qword [rbp-120], rax

	jmp		main_46_mergeBranch

main_46_mergeBranch:
	mov		rax, qword [rbp-120]
	test	rax, rax
	jz		main_48_leftFalse
	jmp		main_47_leftTrue

main_47_leftTrue:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [rbp-176]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-152], rax

	jmp		main_49_mergeBranch

main_48_leftFalse:
	mov		rax, 0
	mov		qword [rbp-152], rax

	jmp		main_49_mergeBranch

main_49_mergeBranch:
	mov		rax, qword [rbp-152]
	test	rax, rax
	jz		main_51_leftFalse
	jmp		main_50_leftTrue

main_50_leftTrue:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [global_var_h]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-168], rax

	jmp		main_52_mergeBranch

main_51_leftFalse:
	mov		rax, 0
	mov		qword [rbp-168], rax

	jmp		main_52_mergeBranch

main_52_mergeBranch:
	mov		rax, qword [rbp-168]
	test	rax, rax
	jz		main_54_leftFalse
	jmp		main_53_leftTrue

main_53_leftTrue:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [global_var_i]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-40], rax

	jmp		main_55_mergeBranch

main_54_leftFalse:
	mov		rax, 0
	mov		qword [rbp-40], rax

	jmp		main_55_mergeBranch

main_55_mergeBranch:
	mov		rax, qword [rbp-40]
	test	rax, rax
	jz		main_57_leftFalse
	jmp		main_56_leftTrue

main_56_leftTrue:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [global_var_j]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-440], rax

	jmp		main_58_mergeBranch

main_57_leftFalse:
	mov		rax, 0
	mov		qword [rbp-440], rax

	jmp		main_58_mergeBranch

main_58_mergeBranch:
	mov		rax, qword [rbp-440]
	test	rax, rax
	jz		main_60_leftFalse
	jmp		main_59_leftTrue

main_59_leftTrue:
	mov		rdx, qword [rbp-160]
	mov		rax, qword [global_var_k]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-352], rax

	jmp		main_61_mergeBranch

main_60_leftFalse:
	mov		rax, 0
	mov		qword [rbp-352], rax

	jmp		main_61_mergeBranch

main_61_mergeBranch:
	mov		rax, qword [rbp-352]
	test	rax, rax
	jz		main_63_leftFalse
	jmp		main_62_leftTrue

main_62_leftTrue:
	mov		rdx, qword [rbp-184]
	mov		rax, qword [rbp-224]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-368], rax

	jmp		main_64_mergeBranch

main_63_leftFalse:
	mov		rax, 0
	mov		qword [rbp-368], rax

	jmp		main_64_mergeBranch

main_64_mergeBranch:
	mov		rax, qword [rbp-368]
	test	rax, rax
	jz		main_66_leftFalse
	jmp		main_65_leftTrue

main_65_leftTrue:
	mov		rdx, qword [rbp-184]
	mov		rax, qword [rbp-56]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-344], rax

	jmp		main_67_mergeBranch

main_66_leftFalse:
	mov		rax, 0
	mov		qword [rbp-344], rax

	jmp		main_67_mergeBranch

main_67_mergeBranch:
	mov		rax, qword [rbp-344]
	test	rax, rax
	jz		main_69_leftFalse
	jmp		main_68_leftTrue

main_68_leftTrue:
	mov		rdx, qword [rbp-184]
	mov		rax, qword [rbp-176]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-328], rax

	jmp		main_70_mergeBranch

main_69_leftFalse:
	mov		rax, 0
	mov		qword [rbp-328], rax

	jmp		main_70_mergeBranch

main_70_mergeBranch:
	mov		rax, qword [rbp-328]
	test	rax, rax
	jz		main_72_leftFalse
	jmp		main_71_leftTrue

main_71_leftTrue:
	mov		rdx, qword [rbp-184]
	mov		rax, qword [global_var_h]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-304], rax

	jmp		main_73_mergeBranch

main_72_leftFalse:
	mov		rax, 0
	mov		qword [rbp-304], rax

	jmp		main_73_mergeBranch

main_73_mergeBranch:
	mov		rax, qword [rbp-304]
	test	rax, rax
	jz		main_75_leftFalse
	jmp		main_74_leftTrue

main_74_leftTrue:
	mov		rdx, qword [rbp-184]
	mov		rax, qword [global_var_i]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-104], rax

	jmp		main_76_mergeBranch

main_75_leftFalse:
	mov		rax, 0
	mov		qword [rbp-104], rax

	jmp		main_76_mergeBranch

main_76_mergeBranch:
	mov		rax, qword [rbp-104]
	test	rax, rax
	jz		main_78_leftFalse
	jmp		main_77_leftTrue

main_77_leftTrue:
	mov		rdx, qword [rbp-184]
	mov		rax, qword [global_var_j]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-128], rax

	jmp		main_79_mergeBranch

main_78_leftFalse:
	mov		rax, 0
	mov		qword [rbp-128], rax

	jmp		main_79_mergeBranch

main_79_mergeBranch:
	mov		rax, qword [rbp-128]
	test	rax, rax
	jz		main_81_leftFalse
	jmp		main_80_leftTrue

main_80_leftTrue:
	mov		rdx, qword [rbp-184]
	mov		rax, qword [global_var_k]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-248], rax

	jmp		main_82_mergeBranch

main_81_leftFalse:
	mov		rax, 0
	mov		qword [rbp-248], rax

	jmp		main_82_mergeBranch

main_82_mergeBranch:
	mov		rax, qword [rbp-248]
	test	rax, rax
	jz		main_84_leftFalse
	jmp		main_83_leftTrue

main_83_leftTrue:
	mov		rdx, qword [rbp-224]
	mov		rax, qword [rbp-56]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-336], rax

	jmp		main_85_mergeBranch

main_84_leftFalse:
	mov		rax, 0
	mov		qword [rbp-336], rax

	jmp		main_85_mergeBranch

main_85_mergeBranch:
	mov		rax, qword [rbp-336]
	test	rax, rax
	jz		main_87_leftFalse
	jmp		main_86_leftTrue

main_86_leftTrue:
	mov		rdx, qword [rbp-224]
	mov		rax, qword [rbp-176]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-264], rax

	jmp		main_88_mergeBranch

main_87_leftFalse:
	mov		rax, 0
	mov		qword [rbp-264], rax

	jmp		main_88_mergeBranch

main_88_mergeBranch:
	mov		rax, qword [rbp-264]
	test	rax, rax
	jz		main_90_leftFalse
	jmp		main_89_leftTrue

main_89_leftTrue:
	mov		rdx, qword [rbp-224]
	mov		rax, qword [global_var_h]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-24], rax

	jmp		main_91_mergeBranch

main_90_leftFalse:
	mov		rax, 0
	mov		qword [rbp-24], rax

	jmp		main_91_mergeBranch

main_91_mergeBranch:
	mov		rax, qword [rbp-24]
	test	rax, rax
	jz		main_93_leftFalse
	jmp		main_92_leftTrue

main_92_leftTrue:
	mov		rdx, qword [rbp-224]
	mov		rax, qword [global_var_i]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-464], rax

	jmp		main_94_mergeBranch

main_93_leftFalse:
	mov		rax, 0
	mov		qword [rbp-464], rax

	jmp		main_94_mergeBranch

main_94_mergeBranch:
	mov		rax, qword [rbp-464]
	test	rax, rax
	jz		main_96_leftFalse
	jmp		main_95_leftTrue

main_95_leftTrue:
	mov		rdx, qword [rbp-224]
	mov		rax, qword [global_var_j]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-232], rax

	jmp		main_97_mergeBranch

main_96_leftFalse:
	mov		rax, 0
	mov		qword [rbp-232], rax

	jmp		main_97_mergeBranch

main_97_mergeBranch:
	mov		rax, qword [rbp-232]
	test	rax, rax
	jz		main_99_leftFalse
	jmp		main_98_leftTrue

main_98_leftTrue:
	mov		rdx, qword [rbp-224]
	mov		rax, qword [global_var_k]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-112], rax

	jmp		main_100_mergeBranch

main_99_leftFalse:
	mov		rax, 0
	mov		qword [rbp-112], rax

	jmp		main_100_mergeBranch

main_100_mergeBranch:
	mov		rax, qword [rbp-112]
	test	rax, rax
	jz		main_102_leftFalse
	jmp		main_101_leftTrue

main_101_leftTrue:
	mov		rdx, qword [rbp-56]
	mov		rax, qword [rbp-176]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-88], rax

	jmp		main_103_mergeBranch

main_102_leftFalse:
	mov		rax, 0
	mov		qword [rbp-88], rax

	jmp		main_103_mergeBranch

main_103_mergeBranch:
	mov		rax, qword [rbp-88]
	test	rax, rax
	jz		main_105_leftFalse
	jmp		main_104_leftTrue

main_104_leftTrue:
	mov		rdx, qword [rbp-56]
	mov		rax, qword [global_var_h]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-312], rax

	jmp		main_106_mergeBranch

main_105_leftFalse:
	mov		rax, 0
	mov		qword [rbp-312], rax

	jmp		main_106_mergeBranch

main_106_mergeBranch:
	mov		rax, qword [rbp-312]
	test	rax, rax
	jz		main_108_leftFalse
	jmp		main_107_leftTrue

main_107_leftTrue:
	mov		rdx, qword [rbp-56]
	mov		rax, qword [global_var_i]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-64], rax

	jmp		main_109_mergeBranch

main_108_leftFalse:
	mov		rax, 0
	mov		qword [rbp-64], rax

	jmp		main_109_mergeBranch

main_109_mergeBranch:
	mov		rax, qword [rbp-64]
	test	rax, rax
	jz		main_111_leftFalse
	jmp		main_110_leftTrue

main_110_leftTrue:
	mov		rdx, qword [rbp-56]
	mov		rax, qword [global_var_j]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-240], rax

	jmp		main_112_mergeBranch

main_111_leftFalse:
	mov		rax, 0
	mov		qword [rbp-240], rax

	jmp		main_112_mergeBranch

main_112_mergeBranch:
	mov		rax, qword [rbp-240]
	test	rax, rax
	jz		main_114_leftFalse
	jmp		main_113_leftTrue

main_113_leftTrue:
	mov		rdx, qword [rbp-56]
	mov		rax, qword [global_var_k]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-488], rax

	jmp		main_115_mergeBranch

main_114_leftFalse:
	mov		rax, 0
	mov		qword [rbp-488], rax

	jmp		main_115_mergeBranch

main_115_mergeBranch:
	mov		rax, qword [rbp-488]
	test	rax, rax
	jz		main_117_leftFalse
	jmp		main_116_leftTrue

main_116_leftTrue:
	mov		rdx, qword [rbp-176]
	mov		rax, qword [global_var_h]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-32], rax

	jmp		main_118_mergeBranch

main_117_leftFalse:
	mov		rax, 0
	mov		qword [rbp-32], rax

	jmp		main_118_mergeBranch

main_118_mergeBranch:
	mov		rax, qword [rbp-32]
	test	rax, rax
	jz		main_120_leftFalse
	jmp		main_119_leftTrue

main_119_leftTrue:
	mov		rdx, qword [rbp-176]
	mov		rax, qword [global_var_i]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-208], rax

	jmp		main_121_mergeBranch

main_120_leftFalse:
	mov		rax, 0
	mov		qword [rbp-208], rax

	jmp		main_121_mergeBranch

main_121_mergeBranch:
	mov		rax, qword [rbp-208]
	test	rax, rax
	jz		main_123_leftFalse
	jmp		main_122_leftTrue

main_122_leftTrue:
	mov		rdx, qword [rbp-176]
	mov		rax, qword [global_var_j]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-320], rax

	jmp		main_124_mergeBranch

main_123_leftFalse:
	mov		rax, 0
	mov		qword [rbp-320], rax

	jmp		main_124_mergeBranch

main_124_mergeBranch:
	mov		rax, qword [rbp-320]
	test	rax, rax
	jz		main_126_leftFalse
	jmp		main_125_leftTrue

main_125_leftTrue:
	mov		rdx, qword [rbp-176]
	mov		rax, qword [global_var_k]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-48], rax

	jmp		main_127_mergeBranch

main_126_leftFalse:
	mov		rax, 0
	mov		qword [rbp-48], rax

	jmp		main_127_mergeBranch

main_127_mergeBranch:
	mov		rax, qword [rbp-48]
	test	rax, rax
	jz		main_129_leftFalse
	jmp		main_128_leftTrue

main_128_leftTrue:
	mov		rdx, qword [global_var_i]
	mov		rax, qword [global_var_j]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-424], rax

	jmp		main_130_mergeBranch

main_129_leftFalse:
	mov		rax, 0
	mov		qword [rbp-424], rax

	jmp		main_130_mergeBranch

main_130_mergeBranch:
	mov		rax, qword [rbp-424]
	test	rax, rax
	jz		main_132_leftFalse
	jmp		main_131_leftTrue

main_131_leftTrue:
	mov		rdx, qword [global_var_h]
	mov		rax, qword [global_var_k]
	cmp		rdx, rax
	setne		al
	movzx	eax, al
	mov		qword [rbp-432], rax

	jmp		main_133_mergeBranch

main_132_leftFalse:
	mov		rax, 0
	mov		qword [rbp-432], rax

	jmp		main_133_mergeBranch

main_133_mergeBranch:
	mov		rax, qword [rbp-432]
	test	rax, rax
	jz		main_135_ifFalse
	jmp		main_134_ifTrue

main_134_ifTrue:
	mov		rax, qword [global_var_total]
	mov		qword [rbp-80], rax

	mov		rax, qword [global_var_total]
	mov		rdx, 1
	add		rax, rdx
	mov		qword [global_var_total], rax

	jmp		main_136_ifMerge

main_135_ifFalse:
	jmp		main_136_ifMerge

main_136_ifMerge:
	jmp		main_137_forIncrease

main_137_forIncrease:
	mov		rax, qword [rbp-176]
	mov		qword [rbp-216], rax

	mov		rax, qword [rbp-176]
	mov		rdx, 1
	add		rax, rdx
	mov		qword [rbp-176], rax

	jmp		main_12_forCondition

main_138_forMerge:
	jmp		main_139_forIncrease

main_139_forIncrease:
	mov		rax, qword [rbp-56]
	mov		qword [rbp-272], rax

	mov		rax, qword [rbp-56]
	mov		rdx, 1
	add		rax, rdx
	mov		qword [rbp-56], rax

	jmp		main_10_forCondition

main_140_forMerge:
	jmp		main_141_forIncrease

main_141_forIncrease:
	mov		rax, qword [rbp-224]
	mov		qword [rbp-200], rax

	mov		rax, qword [rbp-224]
	mov		rdx, 1
	add		rax, rdx
	mov		qword [rbp-224], rax

	jmp		main_8_forCondition

main_142_forMerge:
	jmp		main_143_forIncrease

main_143_forIncrease:
	mov		rax, qword [rbp-184]
	mov		qword [rbp-280], rax

	mov		rax, qword [rbp-184]
	mov		rdx, 1
	add		rax, rdx
	mov		qword [rbp-184], rax

	jmp		main_6_forCondition

main_144_forMerge:
	jmp		main_145_forIncrease

main_145_forIncrease:
	mov		rax, qword [rbp-160]
	mov		qword [rbp-400], rax

	mov		rax, qword [rbp-160]
	mov		rdx, 1
	add		rax, rdx
	mov		qword [rbp-160], rax

	jmp		main_4_forCondition

main_146_forMerge:
	jmp		main_147_forIncrease

main_147_forIncrease:
	mov		rax, qword [rbp-16]
	mov		qword [rbp-408], rax

	mov		rax, qword [rbp-16]
	mov		rdx, 1
	add		rax, rdx
	mov		qword [rbp-16], rax

	jmp		main_2_forCondition

main_148_forMerge:
	mov		rdi, qword [global_var_total]
	call	FBH_toString
	mov		qword [rbp-288], rax

	mov		rdi, qword [rbp-288]
	call	FBH_println

	mov		rax, 0
	leave
	ret

	jmp		main_149_exit

main_149_exit:
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

