@Category(Integer)
class OperationOnInt{

    def triple(){
        return this*3
    }
}

use(OperationOnInt){
    assert 3.triple() == 9
}