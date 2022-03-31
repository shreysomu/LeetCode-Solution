class Solution {
public:
    string intToRoman(int num) {
        
        std::string s;

        while (num != 0)
        {
            if (num >= 1000)
            {
                int n = num;
                num = num % 1000;
                n /= 1000;
                s.insert(s.size(), n, 'M');
            }
            else if(num >= 900)
            {
                num %= 900;
                s += "CM";
            }
            else if(num >= 500)
            {
                num %= 500;
                s += 'D';
            }
            else if(num >= 400)
            {
                num %= 400;
                s += "CD";
            }
            else if(num >= 100)
            {
                int n = num;
                num = num % 100;
                n/= 100;
                s.insert(s.size(), n, 'C');
            }
            else if(num >= 90)
            {
                num %= 90;
                s += "XC";
            }
            else if(num >= 50)
            {
                num %= 50;
                s += 'L';
            }
            else if(num >= 40)
            {
                num %= 40;
                s += "XL";
            }
            else if(num >= 10)
            {
                int n = num;
                num = num % 10;
                n /= 10;
                s.insert(s.size(), n, 'X');
            }
            else if(num >= 9)
            {
                num %= 9;
                s += "IX";
            }
            else if(num >= 5)
            {
                num %= 5;
                s += 'V';
            }
            else if(num >= 4)
            {
                num %= 4;
                s += "IV";
            }
            else
            {
                int n = num;
                num = num % 1;
                n /= 1;
                s.insert(s.size(), n, 'I');
                
                num = 0;
            }
        }
        
        return s;
        
    }
};
