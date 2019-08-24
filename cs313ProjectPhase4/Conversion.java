class Conversion {
    private StackB sb;
    private String inputForConversion;
    private String outputFromConversion = "";

    public Conversion(String string) {
        inputForConversion = string;
        sb = new StackB(string.length());
    }

    private void operatorCheck(char op, int priorA){
        while (!sb.isEmpty()){
            char stuffUpper = sb.pop();
            if (stuffUpper == '('){
                sb.push(stuffUpper);
                break;

                //check break


            } else {
                int priorB;
                if (stuffUpper == '+' || stuffUpper == '-')
                    priorB = 1;

                //check break
                else
                    priorB = 2;
                if (priorB < priorA) {
                    sb.push(stuffUpper);
                    break;

                    // check break

                } else
                    outputFromConversion = outputFromConversion + stuffUpper;
            }
        }
        sb.push(op);
    }

    private void parenthesisCheck(){
        while (!sb.isEmpty()){
            char c = sb.pop();
            if (c == '(')
                break;
            else
                outputFromConversion = outputFromConversion + c;
        }
    }

    public String inToPost() {
        for (int i = 0; i < inputForConversion.length(); i++) {
            char c = inputForConversion.charAt(i);

            switch (c) {
                case '+':
                case '-':
                    operatorCheck(c, 1);
                    break;

                    // case break

                case '*':
                case '/':
                    operatorCheck(c, 2);
                    break;

                    // case break
                case '(':
                    sb.push(c);
                    break;

                    //case break
                case ')':
                    parenthesisCheck();
                    break;

                    //case break
                default:
                    outputFromConversion = outputFromConversion + c;
            }
        }
        while (!sb.isEmpty())
            outputFromConversion = outputFromConversion + sb.pop();
        return outputFromConversion;
    }

}
