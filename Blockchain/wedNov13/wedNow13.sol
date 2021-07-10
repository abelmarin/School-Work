pragma solidity >=0.4.22 <0.6.0;

contract Nov13a {
    address payable[] public queue;
    uint stake_amount = 1 wei;
    
    constructor () public {
        assert(queue.length == 0);
        queue.push(msg.sender);
    }
    
    function buy_in () public payable returns (uint) {
        require(msg.value == stake_amount);
        stake_amount = stake_amount*2;
        queue.push(msg.sender);
        
       return payout(); //optional
        
    }
    
    function payout () public returns (uint) {
        require (queue.length >= 2);
        uint  balance = address(this).balance;
        uint amount = balance / (queue.length - 1);
        for (uint i = 0; i < queue.length -1; i++) {
            queue[i].transfer (amount);
        }
        
        return amount;
    }
    
    function get_balance () public view returns (uint) {
        return address(this).balance;
    }
}