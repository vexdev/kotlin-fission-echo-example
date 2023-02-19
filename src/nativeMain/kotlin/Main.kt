import fission.FissionFunction
import fission.Function
import fission.Header
import fission.Request

fun main() {
    FissionFunction.init(EchoFunction())
}

class EchoFunction : Function {
    override fun onCall(request: Request, headers: List<Header>): String {
        return "Content-Length: ${request.contentLength}\n" +
                "URI: ${request.uri}\n" +
                "Method: ${request.method}\n" +
                "--- BODY BEGINS ---\n" +
                "${request.content}\n" +
                "--- BODY ENDS ---\n"
    }
}