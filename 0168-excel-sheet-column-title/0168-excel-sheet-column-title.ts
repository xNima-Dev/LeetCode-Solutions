function convertToTitle(columnNumber: number): string {
    let result = "";

    while (columnNumber > 0) {
        columnNumber--;
        const charCode = 'A'.charCodeAt(0) + (columnNumber % 26);
        result = String.fromCharCode(charCode) + result;
        columnNumber = Math.floor(columnNumber / 26);
    }

    return result;
}