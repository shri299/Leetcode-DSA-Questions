class Solution {
public:
    string reverseWords(string s) {
        
        stack<string> reversed;
        string temp="";
        bool valid=false;
        
        for(char c : s){
            if(c != ' '){
                temp += c;
                valid = true;
            }
            else{
                if(valid){
                    reversed.push(temp);
                    valid = false;
                    temp = "";
                }
            }
        }
        if(!temp.empty()) reversed.push(temp);
        
        temp = "";
        while(!reversed.empty()){
            if(reversed.size() != 1)
                temp += reversed.top() + ' ';
            else
                temp += reversed.top();
            reversed.pop();
        }
        return temp;
        
        
    }
};