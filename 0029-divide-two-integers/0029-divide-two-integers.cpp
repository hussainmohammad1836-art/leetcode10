class Solution {
public:
    int divide(int dividend, int divisor) {
        bool sign = true;
        if(dividend>=0 && divisor<0) sign =  false;
        else if(dividend<0 && divisor>0) sign =  false;

        long long n = llabs((long long)dividend);
        long long d = abs((long long)divisor);
        long ans=0;
        while(n>=d){
            int pw=0;
            while(n>= (d<<(pw+1))){
                pw++;
            }
            ans += 1<<(pw);
            n = n-(d<<(pw));
        }
        if(ans==(1<<31) && sign == true) return INT_MAX;
        if(ans==(1<<31) && sign == false) return INT_MIN;
        return sign ? ans : -ans;
    }
};