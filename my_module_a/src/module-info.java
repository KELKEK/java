module my_module_a {
	exports pack1;
	exports pack2;//외부에서 쓸 수 있다.(밖으로 내보낼 수 있다.)
	requires  my_module_b;//(안으로 가져올 수 있다.)
}