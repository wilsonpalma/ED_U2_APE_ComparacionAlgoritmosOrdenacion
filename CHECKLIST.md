# CHECKLIST - Entrega Taller 6 (Comparación de Ordenación) - Versión final

## Estructura mínima (verificar)
- [x] `/src/` → código Java (paquete `sorting` o el que se use)
  - `BubbleSort.java` (instrumentado)
  - `SelectionSort.java` (instrumentado)
  - `InsertionSort.java` (instrumentado, cuenta `shifts`)
  - `SortingDemo.java` (harness que genera `resultados_ordenacion.csv`)
  - `SortingStats.java` / `SortingUtils.java` (helpers)
- [x] `/datasets/` → contiene exactamente los 4 CSV (UTF-8 sin BOM, separador `; `, encabezado):
  - `citas_100.csv`
  - `citas_100_casi_ordenadas.csv`
  - `pacientes_500.csv`
  - `inventario_500_inverso.csv`
- [x] `/logs/` → salida(s) de ejecución (por ejemplo `logs/salida.txt`)
- [x] `resultados_ordenacion.csv` en la raíz del repo (archivo resumen obligatorio)
- [x] `README.md` y `CHECKLIST.md` en la raíz

## Formatos y requisitos técnicos
- [x] Archivos CSV de datasets: codificación **UTF-8 sin BOM**, separador `; `, encabezado en la primera fila.
- [x] `resultados_ordenacion.csv`: formato EXACTO (ver sección siguiente).

## Ejecución experimental (obligatorio)
- [x] Parámetros experimentales en `SortingDemo.java` o en README:
  - `R >= 10` (recomendado: 10)
  - `DISCARD = 3`
- [x] Aislar I/O: cargar CSV **antes** de las repeticiones; medir sólo la rutina de ordenación con `System.nanoTime()`.
- [x] No imprimir/trazar durante la medición cronometrada.
- [x] Detectar y registrar si algún resultado no queda ordenado (verificación automática).
- [x] Guardar todas las ejecuciones en `logs/` (cada run debe incluir run#, time_ns, comparisons, swaps, shifts).

## Archivo de resultados obligatorio
- [x] `resultados_ordenacion.csv` (archivo en la raíz) con cabecera EXACTA y separador `; `:
  `
  dataset;n;algoritmo;median_time_ns;median_comparisons;median_swaps;median_shifts
  `
- [x] Debe contener 12 filas de datos (4 datasets × 3 algoritmos) + 1 cabecera = 13 líneas totales.
- [x] Revisar que los valores empíricos reflejen la mediana de `R - DISCARD` ejecuciones.

## Evidencia y verificación
- [x] `logs/` contiene la salida completa (R ejecuciones por algoritmo/dataset).
- [x] Ejecutar `SortingDemo` tal como se indica en README y confirmar que:
  - `resultados_ordenacion.csv` se generó en la raíz.
  - No se reportaron advertencias de orden incorrecto.

## README / documentación mínima
- [x] Compilación documentada: `javac -d out src/sorting/*.java`
- [x] Ejecución documentada: `java -cp out sorting.SortingDemo`
- [x] Valores experimentales documentados: `R`, `DISCARD`, semilla = 42
- [x] Indicar que la medición excluye I/O

## Verificación final (antes de subir)
- [x] `datasets/` contiene 4 CSV con conteos: 100 / 100 / 500 / 500.
- [x] `resultados_ordenacion.csv` existe en la raíz y tiene 13 líneas.
- [x] `logs/` contiene evidencia de las repeticiones.
- [x] README e instrucciones están completas y verificables.
- [x] Realizar un commit final que incluya: `/src/`, `/datasets/`, `/logs/`, `resultados_ordenacion.csv`, `README.md`, `CHECKLIST.md`.