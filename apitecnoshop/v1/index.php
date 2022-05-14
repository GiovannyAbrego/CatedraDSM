<?php
/**
 *
 * @About:      API Clinica
 * @File:       index.php
 * @Date:       01/10/2021
 * @Version:    $Rev:$ 1.0
 * @Developer:  DPS
 **/

header("Access-Control-Allow-Origin: *");
header('Access-Control-Allow-Methods: PUT, GET, POST, DELETE, OPTIONS');
header('Content-Type: application/json; charset=utf-8');

include_once '../include/Config.php';

require '../libs/Slim/Slim.php';
\Slim\Slim::registerAutoloader();
$app = new \Slim\Slim();

require_once '../include/Tecnoshop.php';



$app->get('/productos/', function(){
        $dbh = new Tecnoshop();
        $response = $dbh-> seleccionarProductos();
    
    // Request with status response
    echo json_encode($response);
});

$app->get('/fabricantes/', function(){
        $dbh = new Tecnoshop();
        $response = $dbh-> seleccionarFabricante();
    
    // Request with status response
    echo json_encode($response);
});

$app->get('/categorias/', function(){
        $dbh = new Tecnoshop();
        $response = $dbh-> seleccionarCategoria();
    
    // Request with status response
    echo json_encode($response);
});

$app->get('/comentarios/', function(){
        $dbh = new Tecnoshop();
        $response = $dbh-> seleccionarComentarios();
    
    // Request with status response
    echo json_encode($response);
});
/* corremos la aplicación */
$app->run();

/**
 * Mostrando la respuesta en formato json al cliente o navegador
 * @param String $status_code Http response code
 * @param Int $response Json response
 */
function echoResponse($status_code, $response) {
    $app = \Slim\Slim::getInstance();
    // Http response code
    $app->status($status_code);

    // setting response content type to json
    $app->contentType('application/json');

    echo json_encode($response);
}
?>
