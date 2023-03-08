<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oficina De Trabajo Facultad</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/home.css">
    <!-- https://icons.getbootstrap.com/ -->
  </head>
<body>

<div class="container mt-3">
  <div class="row justify-content-md-center">
    <div class="col-md-12">
      <h1 class="text-center mt-3"> Oficina de trabajo Facultad </h1>
      <p>Diligenciar oferta</p>
        <a href="./"><i class="bi bi-house"></i></a>
        <a href=""></a>
        <hr class="mb-3">
    </div>


    <div class="col-md-4 mb-3">
      <h3 class="text-center">Datos oferta</h3>
      <form method="POST" action="action.php" enctype="multipart/form-data">
        <input type="text" name="metodo" value="1" hidden>
        <div class="mb-3">
          <label class="form-label">Nombre de la institución</label>
          <input type="number" name="nombreInstitucion" class="form-control" required>
        </div>

        <div class="mb-3">
        <label for="Sexo">Tipo de remitente</label>
          <div class="form-check">
            <input class="form-check-input" type="radio" name="tipoRemitente" value="E" checked>
            <label class="form-check-label" for="empresa">
              Empresa
            </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="tipoRemitente" value="F">
          <label class="form-check-label" for="facultad">
            Facultad
          </label>
        </div>
        </div>
        <div class="mb-3">
          <label class="form-label">Descripción del empleo</label>
          <input type="text" class="form-control" name="descripcion" required>
        </div>

        <div class="d-grid gap-2 col-12 mx-auto">
          <button type="submit" class="btn  btn btn-primary mt-3 mb-2">
            Registrar oferta
            <i class="bi bi-arrow-right-circle"></i>
          </button>
        </div>
        
      </form>
    </div>


    <?php
    include('config.php');
    $sqlAlumnos   = ("SELECT * FROM table_alumnos ORDER BY id DESC");
    $queryAlumnos = mysqli_query($con, $sqlAlumnos);
     $totalAlumnos = mysqli_num_rows($queryAlumnos);

    ?>
    <div class="col-md-8">
    <h3 class="text-center">Lista de Ofertas <?php echo '(' . $totalAlumnos . ')'; ?></h3>
      <div class="row">
        <div class="col-md-12 p-2">
          <div class="table-responsive">
            <table class="table table-bordered table-striped table-hover">
              <thead>
                <tr>
                  <th>#</th>
                  <th scope="col">idOferta<th>
                  <th scope="col">nombreInstitucion</th>
                  <th scope="col">tipoRemitente</th>
                  <th scope="col">descripcion</th>
                </tr>
              </thead>
              <tbody>
              <?php
              $conteo =1;
              while ($dataAlumno = mysqli_fetch_array($queryAlumnos)) { ?>
                <tr>
                <td><?php echo  $conteo++ .')'; ?></td>
                  <td><?php echo $dataAlumno['nombreInstitucion']; ?></td>
                  <td><?php echo $dataAlumno['cedula']; ?></td>
                  <td><?php echo $dataAlumno['tipoRemitente']==='E' ?  'Empresa' : 'Facultad' ?></td>
                </tr>
              <?php } ?>
            </table>
          </div>
        </div>
      </div>
    </div>

  </div>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
$(function(){
  $('.toast').toast('show');
});
</script>

</body>
</html>