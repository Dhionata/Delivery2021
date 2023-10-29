package br.com.repository

import br.com.model.ProdutoFornecedor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProdutoFornecedorRepository : JpaRepository<ProdutoFornecedor, Int>
