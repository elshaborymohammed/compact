package com.smart.sample.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0003\b\u00c8\u0001\b\u0086\b\u0018\u00002\u00020\u0001B\u00b9\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u00105J\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010hJ\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a1\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a4\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a5\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a7\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a8\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00aa\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00ac\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00af\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b0\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b1\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b2\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b3\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b4\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b5\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b6\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b8\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00b9\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00ba\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00bb\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00bd\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00be\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00bf\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c0\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c1\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c2\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c3\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c4\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c5\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c6\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c7\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00c8\u0001\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0011\u0010\u00c9\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010UJ\f\u0010\u00ca\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u00cb\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u00cc\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010UJ\u00c4\u0004\u0010\u00cd\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0003\u0010\u00ce\u0001J\u0015\u0010\u00cf\u0001\u001a\u00020\u000b2\t\u0010\u00d0\u0001\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\n\u0010\u00d1\u0001\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u00d2\u0001\u001a\u00020\u0005H\u0016R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00107\"\u0004\b=\u00109R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00107\"\u0004\bA\u00109R \u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u00107\"\u0004\bC\u00109R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u00107\"\u0004\bE\u00109R \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u00107\"\u0004\bG\u00109R \u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u00107\"\u0004\bI\u00109R \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u00107\"\u0004\bK\u00109R \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u00107\"\u0004\bM\u00109R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u00107\"\u0004\bO\u00109R \u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u00107\"\u0004\bQ\u00109R \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u00107\"\u0004\bS\u00109R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010X\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u00107\"\u0004\bZ\u00109R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u00107\"\u0004\b\\\u00109R \u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u00107\"\u0004\b^\u00109R \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u00107\"\u0004\b`\u00109R \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u00107\"\u0004\bb\u00109R \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u00107\"\u0004\bd\u00109R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u00107\"\u0004\bf\u00109R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010k\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u00107\"\u0004\bm\u00109R \u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u00107\"\u0004\bo\u00109R \u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u00107\"\u0004\bq\u00109R \u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u00107\"\u0004\bs\u00109R \u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u00107\"\u0004\bu\u00109R \u0010\'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u00107\"\u0004\bw\u00109R \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u00107\"\u0004\by\u00109R \u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u00107\"\u0004\b{\u00109R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u00107\"\u0004\b}\u00109R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b~\u00107\"\u0004\b\u007f\u00109R\"\u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u00107\"\u0005\b\u0081\u0001\u00109R$\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R$\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0002\u0010X\u001a\u0005\b\u0086\u0001\u0010U\"\u0005\b\u0087\u0001\u0010WR\"\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u00107\"\u0005\b\u0089\u0001\u00109R\"\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u00107\"\u0005\b\u008b\u0001\u00109R\"\u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u00107\"\u0005\b\u008d\u0001\u00109R\"\u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u00107\"\u0005\b\u008f\u0001\u00109R\"\u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u00107\"\u0005\b\u0091\u0001\u00109R\"\u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u00107\"\u0005\b\u0093\u0001\u00109R\"\u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u00107\"\u0005\b\u0095\u0001\u00109R\"\u00102\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u00107\"\u0005\b\u0097\u0001\u00109R\"\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u00107\"\u0005\b\u0099\u0001\u00109R\"\u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u00107\"\u0005\b\u009b\u0001\u00109R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u00107\"\u0005\b\u009d\u0001\u00109\u00a8\u0006\u00d3\u0001"}, d2 = {"Lcom/smart/sample/domain/model/Trend;", "", "id", "", "nodeId", "", "name", "fullName", "owner", "Lcom/smart/sample/domain/model/Owner;", "private", "", "htmlUrl", "description", "fork", "url", "archiveUrl", "assigneesUrl", "blobsUrl", "branchesUrl", "collaboratorsUrl", "commentsUrl", "commitsUrl", "compareUrl", "contentsUrl", "contributorsUrl", "deploymentsUrl", "downloadsUrl", "eventsUrl", "forksUrl", "gitCommitsUrl", "gitRefsUrl", "gitTagsUrl", "gitUrl", "issueCommentUrl", "issueEventsUrl", "issuesUrl", "keysUrl", "labelsUrl", "languagesUrl", "mergesUrl", "milestonesUrl", "notificationsUrl", "pullsUrl", "releasesUrl", "sshUrl", "stargazersUrl", "statusesUrl", "subscribersUrl", "subscriptionUrl", "tagsUrl", "teamsUrl", "treesUrl", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/smart/sample/domain/model/Owner;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArchiveUrl", "()Ljava/lang/String;", "setArchiveUrl", "(Ljava/lang/String;)V", "getAssigneesUrl", "setAssigneesUrl", "getBlobsUrl", "setBlobsUrl", "getBranchesUrl", "setBranchesUrl", "getCollaboratorsUrl", "setCollaboratorsUrl", "getCommentsUrl", "setCommentsUrl", "getCommitsUrl", "setCommitsUrl", "getCompareUrl", "setCompareUrl", "getContentsUrl", "setContentsUrl", "getContributorsUrl", "setContributorsUrl", "getDeploymentsUrl", "setDeploymentsUrl", "getDescription", "setDescription", "getDownloadsUrl", "setDownloadsUrl", "getEventsUrl", "setEventsUrl", "getFork", "()Ljava/lang/Boolean;", "setFork", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getForksUrl", "setForksUrl", "getFullName", "setFullName", "getGitCommitsUrl", "setGitCommitsUrl", "getGitRefsUrl", "setGitRefsUrl", "getGitTagsUrl", "setGitTagsUrl", "getGitUrl", "setGitUrl", "getHtmlUrl", "setHtmlUrl", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIssueCommentUrl", "setIssueCommentUrl", "getIssueEventsUrl", "setIssueEventsUrl", "getIssuesUrl", "setIssuesUrl", "getKeysUrl", "setKeysUrl", "getLabelsUrl", "setLabelsUrl", "getLanguagesUrl", "setLanguagesUrl", "getMergesUrl", "setMergesUrl", "getMilestonesUrl", "setMilestonesUrl", "getName", "setName", "getNodeId", "setNodeId", "getNotificationsUrl", "setNotificationsUrl", "getOwner", "()Lcom/smart/sample/domain/model/Owner;", "setOwner", "(Lcom/smart/sample/domain/model/Owner;)V", "getPrivate", "setPrivate", "getPullsUrl", "setPullsUrl", "getReleasesUrl", "setReleasesUrl", "getSshUrl", "setSshUrl", "getStargazersUrl", "setStargazersUrl", "getStatusesUrl", "setStatusesUrl", "getSubscribersUrl", "setSubscribersUrl", "getSubscriptionUrl", "setSubscriptionUrl", "getTagsUrl", "setTagsUrl", "getTeamsUrl", "setTeamsUrl", "getTreesUrl", "setTreesUrl", "getUrl", "setUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/smart/sample/domain/model/Owner;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/smart/sample/domain/model/Trend;", "equals", "other", "hashCode", "toString", "sample_debug"})
public final class Trend {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "node_id")
    private java.lang.String nodeId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "full_name")
    private java.lang.String fullName;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "owner")
    private com.smart.sample.domain.model.Owner owner;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "html_url")
    private java.lang.String htmlUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "description")
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "fork")
    private java.lang.Boolean fork;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "url")
    private java.lang.String url;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "archive_url")
    private java.lang.String archiveUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "assignees_url")
    private java.lang.String assigneesUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "blobs_url")
    private java.lang.String blobsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "branches_url")
    private java.lang.String branchesUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "collaborators_url")
    private java.lang.String collaboratorsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "comments_url")
    private java.lang.String commentsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "commits_url")
    private java.lang.String commitsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "compare_url")
    private java.lang.String compareUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "contents_url")
    private java.lang.String contentsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "contributors_url")
    private java.lang.String contributorsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "deployments_url")
    private java.lang.String deploymentsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "downloads_url")
    private java.lang.String downloadsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "events_url")
    private java.lang.String eventsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "forks_url")
    private java.lang.String forksUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "git_commits_url")
    private java.lang.String gitCommitsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "git_refs_url")
    private java.lang.String gitRefsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "git_tags_url")
    private java.lang.String gitTagsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "git_url")
    private java.lang.String gitUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "issue_comment_url")
    private java.lang.String issueCommentUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "issue_events_url")
    private java.lang.String issueEventsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "issues_url")
    private java.lang.String issuesUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "keys_url")
    private java.lang.String keysUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "labels_url")
    private java.lang.String labelsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "languages_url")
    private java.lang.String languagesUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "merges_url")
    private java.lang.String mergesUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "milestones_url")
    private java.lang.String milestonesUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "notifications_url")
    private java.lang.String notificationsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "pulls_url")
    private java.lang.String pullsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "releases_url")
    private java.lang.String releasesUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "ssh_url")
    private java.lang.String sshUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "stargazers_url")
    private java.lang.String stargazersUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "statuses_url")
    private java.lang.String statusesUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "subscribers_url")
    private java.lang.String subscribersUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "subscription_url")
    private java.lang.String subscriptionUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "tags_url")
    private java.lang.String tagsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "teams_url")
    private java.lang.String teamsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "trees_url")
    private java.lang.String treesUrl;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNodeId() {
        return null;
    }
    
    public final void setNodeId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFullName() {
        return null;
    }
    
    public final void setFullName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.smart.sample.domain.model.Owner getOwner() {
        return null;
    }
    
    public final void setOwner(@org.jetbrains.annotations.Nullable()
    com.smart.sample.domain.model.Owner p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getPrivate() {
        return null;
    }
    
    public final void setPrivate(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHtmlUrl() {
        return null;
    }
    
    public final void setHtmlUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getFork() {
        return null;
    }
    
    public final void setFork(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getArchiveUrl() {
        return null;
    }
    
    public final void setArchiveUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAssigneesUrl() {
        return null;
    }
    
    public final void setAssigneesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBlobsUrl() {
        return null;
    }
    
    public final void setBlobsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBranchesUrl() {
        return null;
    }
    
    public final void setBranchesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCollaboratorsUrl() {
        return null;
    }
    
    public final void setCollaboratorsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommentsUrl() {
        return null;
    }
    
    public final void setCommentsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommitsUrl() {
        return null;
    }
    
    public final void setCommitsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCompareUrl() {
        return null;
    }
    
    public final void setCompareUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContentsUrl() {
        return null;
    }
    
    public final void setContentsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContributorsUrl() {
        return null;
    }
    
    public final void setContributorsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeploymentsUrl() {
        return null;
    }
    
    public final void setDeploymentsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDownloadsUrl() {
        return null;
    }
    
    public final void setDownloadsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEventsUrl() {
        return null;
    }
    
    public final void setEventsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getForksUrl() {
        return null;
    }
    
    public final void setForksUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGitCommitsUrl() {
        return null;
    }
    
    public final void setGitCommitsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGitRefsUrl() {
        return null;
    }
    
    public final void setGitRefsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGitTagsUrl() {
        return null;
    }
    
    public final void setGitTagsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGitUrl() {
        return null;
    }
    
    public final void setGitUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIssueCommentUrl() {
        return null;
    }
    
    public final void setIssueCommentUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIssueEventsUrl() {
        return null;
    }
    
    public final void setIssueEventsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIssuesUrl() {
        return null;
    }
    
    public final void setIssuesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getKeysUrl() {
        return null;
    }
    
    public final void setKeysUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLabelsUrl() {
        return null;
    }
    
    public final void setLabelsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLanguagesUrl() {
        return null;
    }
    
    public final void setLanguagesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMergesUrl() {
        return null;
    }
    
    public final void setMergesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMilestonesUrl() {
        return null;
    }
    
    public final void setMilestonesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNotificationsUrl() {
        return null;
    }
    
    public final void setNotificationsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPullsUrl() {
        return null;
    }
    
    public final void setPullsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReleasesUrl() {
        return null;
    }
    
    public final void setReleasesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSshUrl() {
        return null;
    }
    
    public final void setSshUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStargazersUrl() {
        return null;
    }
    
    public final void setStargazersUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatusesUrl() {
        return null;
    }
    
    public final void setStatusesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSubscribersUrl() {
        return null;
    }
    
    public final void setSubscribersUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSubscriptionUrl() {
        return null;
    }
    
    public final void setSubscriptionUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTagsUrl() {
        return null;
    }
    
    public final void setTagsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTeamsUrl() {
        return null;
    }
    
    public final void setTeamsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTreesUrl() {
        return null;
    }
    
    public final void setTreesUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public Trend(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String nodeId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String fullName, @org.jetbrains.annotations.Nullable()
    com.smart.sample.domain.model.Owner owner, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean p5_1990234817, @org.jetbrains.annotations.Nullable()
    java.lang.String htmlUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean fork, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String archiveUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String assigneesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String blobsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String branchesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String collaboratorsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String commentsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String commitsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String compareUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String contentsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String contributorsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String deploymentsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String eventsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String forksUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String gitCommitsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String gitRefsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String gitTagsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String gitUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String issueCommentUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String issueEventsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String issuesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String keysUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String labelsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String languagesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String mergesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String milestonesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String notificationsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String pullsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String releasesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String sshUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String stargazersUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String statusesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String subscribersUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String subscriptionUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String tagsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String teamsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String treesUrl) {
        super();
    }
    
    public Trend() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.smart.sample.domain.model.Owner component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component34() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component35() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component36() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component37() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component38() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component39() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component40() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component41() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component42() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component43() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component44() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component45() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component46() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component47() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smart.sample.domain.model.Trend copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String nodeId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String fullName, @org.jetbrains.annotations.Nullable()
    com.smart.sample.domain.model.Owner owner, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean p5_1990234817, @org.jetbrains.annotations.Nullable()
    java.lang.String htmlUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean fork, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String archiveUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String assigneesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String blobsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String branchesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String collaboratorsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String commentsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String commitsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String compareUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String contentsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String contributorsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String deploymentsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String eventsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String forksUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String gitCommitsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String gitRefsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String gitTagsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String gitUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String issueCommentUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String issueEventsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String issuesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String keysUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String labelsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String languagesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String mergesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String milestonesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String notificationsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String pullsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String releasesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String sshUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String stargazersUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String statusesUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String subscribersUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String subscriptionUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String tagsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String teamsUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String treesUrl) {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
}