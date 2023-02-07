provider "aws" {
  region = "ap-south-1"
}
resource "aws_instance" "dev" {
  ami           = "ami-0cca134ec43cf708f"
  instance_type = "t2.nano"
  count         = 1
  tags = {
  Name = "terraform"
}
}
