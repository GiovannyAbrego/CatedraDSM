<?php

class Tecnoshop {

	    function __construct() {
        require_once dirname(__FILE__) . './DbConnect.php';
        //Abriendo la conexion a la base de datos
        $db = new DbConnect();
        $this->conn = $db->connect();
    }

    public function seleccionarProductos(){
        $sql =  "SELECT p.id_producto, p.nombre_producto, p.precio, f.nombre_fabricante,p.stock,p.img_producto FROM productos p INNER JOIN fabricante f ON p.fabricante = f.id_fabricante INNER JOIN categoria c ON p.categoria = c.id_categoria";
        $stmt=  $this->conn->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_OBJ);
    }
    public function seleccionarFabricante(){
        $sql =  "SELECT * FROM fabricante;";
        $stmt=  $this->conn->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_OBJ);
    }
    public function seleccionarCategoria(){
        $sql =  "SELECT * FROM categoria;";
        $stmt=  $this->conn->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_OBJ);
    }
    public function seleccionarComentarios(){
        $sql =  "SELECT c.id_comentario, p.nombre_producto, c.comentario, c.id_usuario,c.puntuacion FROM comentarios c INNER JOIN productos p ON c.producto = p.id_producto;";
        $stmt=  $this->conn->prepare($sql);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_OBJ);
    }
          
}
?>