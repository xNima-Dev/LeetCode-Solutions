function reverseBits(n: number): number {
    let result = 0;

    for (let i = 0; i < 32; i++) {
        result = (result << 1) | (n & 1);
        n >>>= 1; // Unsigned right shift
    }

    return result >>> 0; // Unsigned 32-bit integer එකක් ලෙස Return කිරීම
}