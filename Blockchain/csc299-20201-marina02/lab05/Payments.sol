pragma solidity >=0.4.22 <0.6.0;
contract Payments {
  uint256 public n1;
  uint256 public n2;
  uint256 public n3;
  uint256 public n4;
  address payable public owner;
  address public contractAddress;
  
  constructor () public {
      owner = msg.sender;
      contractAddress = address(this);
  }
  
  function set1 (uint256 x) public {
      n1 = x;
  }
  
  function set2 (uint256 x) public payable {
      require (msg.value >= 0.00001 ether);
      n2 = x;
  }
  
  function set3 (uint256 x) public payable {
      uint256 amountZabo = 1000000000000*100;
      uint256 amountContract = contractAddress.balance/10;
      if (amountContract>amountZabo) {
          msg.sender.transfer(amountZabo);
      } else {
          msg.sender.transfer(amountContract);
      }
      n3 = x;
  }
  
  function set4 (uint256 x) public {
      require (msg.sender == owner);
      n4 = x;
  }
}
