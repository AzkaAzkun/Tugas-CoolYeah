public class SupportSystem {
    private InputReader Input;
    private GenerateAnswer Response;

    public SupportSystem(){
        Input = new InputReader();
        Response = new GenerateAnswer();
    }

    public void start(){
        Boolean isFinished = false;
        Opening();
        while(!isFinished){
            String CurrentInput = Input.GetScan();
            if(CurrentInput.contains("bye")){
                isFinished = true;
            }else{
                System.out.println(Response.getResponse(CurrentInput));
            }
        }
        SayBye();
    }

    private void Opening(){
        System.out.println("Haloooo nanti kalau udahan bilang 'bye' yah!");
    }

    private void SayBye(){
        System.out.println("Okeeee byeeee....");
    }
}
