package br.com.youready.article.d_2025_03_10.image3

def romanMap = [
    1000: "M",
    900: "CM", 500: "D", 400: "CD", 100: "C",
    90: "XC", 50: "L", 40: "XL", 10: "X",
    9: "IX", 5: "V", 4: "IV", 1: "I"
]

def numberToRoman2(int number) {
    def result = ""

    romanMap.each { divisor, symbol ->
        result += symbol * (number / divisor)
        number %= divisor
    }

    return result
}
