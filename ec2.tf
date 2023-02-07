provider "aws" {
  region = "ap-south-1"
}
resource "aws_instance" "dev" {
  ami           = "ami-0cca134ec43cf708f"
  instance_type = "t2.nano"
  tags          = local.common_tags
  count         = 3
}
locals {
  common_tags = {
  Owner = "Siva"
  service = "backend"
  }
 }