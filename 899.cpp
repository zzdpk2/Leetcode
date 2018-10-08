#include <iostream>
#include <string>

using namespace std;

int main(){
  if(K == 1) 
        {
            string minStr = S;
            for(int i = 1; i < S.size(); ++i)
            {
                S = S.back() + S.substr(0, S.size()-1);
                if(S < minStr) minStr = S;
            }

            return minStr;
        }
        else 
        {
            sort(S.begin(), S.end());
            return S;
        }
    }

}